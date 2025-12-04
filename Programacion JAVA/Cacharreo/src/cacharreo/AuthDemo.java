
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.*;
import java.util.Base64;

public class AuthDemo {

    static final String DB_FILE = "users.txt";
    static final int ITERATIONS = 120_000;
    static final int SALT_BYTES = 16;
    static final int KEY_LENGTH_BITS = 256;

    static class UserRecord {
        String username;
        String firstName;
        String lastName;
        int iterations;
        byte[] salt;
        byte[] hash;
        UserRecord(String u, String fn, String ln, int it, byte[] s, byte[] h) {
            this.username = u; this.firstName = fn; this.lastName = ln;
            this.iterations = it; this.salt = s; this.hash = h;
        }
    }

    static String trim(String s) {
        if (s == null) return "";
        int start = 0, end = s.length() - 1;
        while (start <= end && " \t\r\n".indexOf(s.charAt(start)) >= 0) start++;
        while (end >= start && " \t\r\n".indexOf(s.charAt(end)) >= 0) end--;
        return (start > end) ? "" : s.substring(start, end + 1);
    }

    static List<UserRecord> loadDb() {
        List<UserRecord> users = new ArrayList<>();
        File f = new File(DB_FILE);
        if (!f.exists()) return users;
        try (BufferedReader br = new BufferedReader(new FileReader(f, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\|");
                if (parts.length != 6) continue;
                String username = trim(parts[0]);
                String firstName = trim(parts[1]);
                String lastName = trim(parts[2]);
                int iterations;
                try { iterations = Integer.parseInt(parts[3]); } catch (NumberFormatException e) { continue; }
                byte[] salt, hash;
                try {
                    salt = Base64.getDecoder().decode(parts[4]);
                    hash = Base64.getDecoder().decode(parts[5]);
                } catch (IllegalArgumentException e) { continue; }
                if (!username.isEmpty() && salt.length > 0 && hash.length > 0) {
                    users.add(new UserRecord(username, firstName, lastName, iterations, salt, hash));
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer la BD: " + e.getMessage());
        }
        return users;
    }

    static boolean saveDb(List<UserRecord> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DB_FILE, StandardCharsets.UTF_8, false))) {
            for (UserRecord u : users) {
                bw.write(u.username); bw.write("|");
                bw.write(u.firstName); bw.write("|");
                bw.write(u.lastName); bw.write("|");
                bw.write(Integer.toString(u.iterations)); bw.write("|");
                bw.write(Base64.getEncoder().encodeToString(u.salt)); bw.write("|");
                bw.write(Base64.getEncoder().encodeToString(u.hash));
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println("No se pudo escribir la BD: " + e.getMessage());
            return false;
        }
    }

    static boolean addUser(String username, String firstName, String lastName,
                           int iterations, byte[] salt, byte[] hash) {
        List<UserRecord> users = loadDb();
        for (UserRecord r : users) {
            if (r.username.equals(username)) return false;
        }
        users.add(new UserRecord(username, firstName, lastName, iterations, salt, hash));
        return saveDb(users);
    }

    static UserRecord findUser(String username) {
        for (UserRecord r : loadDb()) {
            if (r.username.equals(username)) return r;
        }
        return null;
    }

    static boolean updateUserHash(String username, int newIterations, byte[] newSalt, byte[] newHash) {
        List<UserRecord> users = loadDb();
        boolean updated = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).username.equals(username)) {
                UserRecord old = users.get(i);
                users.set(i, new UserRecord(username, old.firstName, old.lastName, newIterations, newSalt, newHash));
                updated = true;
                break;
            }
        }
        return updated && saveDb(users);
    }

    static boolean validUsername(String username) {
        if (username == null) return false;
        if (username.isEmpty() || username.length() > 64) return false;
        if (username.contains("|")) return false;
        return username.equals(trim(username));
    }

    static boolean validNameField(String s) {
        if (s == null) return false;
        s = trim(s);
        if (s.isEmpty() || s.length() > 64) return false;
        if (s.contains("|")) return false;
        return true;
    }

    static boolean weakPassword(String pwd) {
        if (pwd == null) return true;
        boolean longEnough = pwd.length() >= 8;
        boolean hasDigit = pwd.chars().anyMatch(Character::isDigit);
        boolean hasLower = pwd.chars().anyMatch(Character::isLowerCase);
        boolean hasUpper = pwd.chars().anyMatch(Character::isUpperCase);
        String syms = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?`~";
        boolean hasSymbol = pwd.chars().anyMatch(c -> syms.indexOf(c) >= 0);
        return !(longEnough && hasDigit && hasLower && hasUpper && hasSymbol);
    }

    static byte[] randomBytes(int n) {
        byte[] b = new byte[n];
        new SecureRandom().nextBytes(b);
        return b;
    }

    static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int keyLengthBits) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLengthBits);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("PBKDF2 error: " + e.getMessage(), e);
        }
    }

    static boolean constantTimeEquals(byte[] a, byte[] b) {
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;
        int result = 0;
        for (int i = 0; i < a.length; i++) result |= (a[i] ^ b[i]);
        return result == 0;
    }

    static void printMenu() {
        System.out.println("\n=== DEMO Auth (PBKDF2 + SAL) ===");
        System.out.println("1) Registrarse");
        System.out.println("2) Iniciar sesión");
        System.out.println("3) Salir");
        System.out.print("Seleccione opción: ");
    }

    public static void main(String[] args) {
        ensureDbExists();
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        while (true) {
            printMenu();
            String opt = sc.nextLine();
            if ("1".equals(opt)) {
                System.out.print("Usuario: ");
                String username = trim(sc.nextLine());
                if (!validUsername(username)) {
                    System.out.println("Usuario inválido.");
                    continue;
                }
                System.out.print("Nombre: ");
                String firstName = trim(sc.nextLine());
                if (!validNameField(firstName)) {
                    System.out.println("Nombre inválido.");
                    continue;
                }
                System.out.print("Apellido: ");
                String lastName = trim(sc.nextLine());
                if (!validNameField(lastName)) {
                    System.out.println("Apellido inválido.");
                    continue;
                }
                System.out.print("Contraseña: ");
                String password = sc.nextLine();
                if (weakPassword(password)) {
                    System.out.println("Contraseña débil.");
                }
                if (findUser(username) != null) {
                    System.out.println("El usuario ya existe.");
                    continue;
                }
                byte[] salt = randomBytes(SALT_BYTES);
                byte[] hash = pbkdf2(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH_BITS);
                if (addUser(username, firstName, lastName, ITERATIONS, salt, hash)) {
                    System.out.println("Registrado con éxito.");
                } else {
                    System.out.println("No se pudo guardar el usuario.");
                }

            } else if ("2".equals(opt)) {
                System.out.print("Usuario: ");
                String username = trim(sc.nextLine());
                UserRecord rec = findUser(username);
                if (rec == null) {
                    System.out.println("Usuario no encontrado.");
                    continue;
                }
                System.out.print("Contraseña: ");
                String password = sc.nextLine();
                byte[] candidate = pbkdf2(password.toCharArray(), rec.salt, rec.iterations, KEY_LENGTH_BITS);
                if (constantTimeEquals(candidate, rec.hash)) {
                    System.out.println("Autenticación correcta.");
                    System.out.println("Bienvenido, " + rec.firstName + " " + rec.lastName + "!");
                    if (ITERATIONS > rec.iterations) {
                        byte[] newSalt = randomBytes(SALT_BYTES);
                        byte[] newHash = pbkdf2(password.toCharArray(), newSalt, ITERATIONS, KEY_LENGTH_BITS);
                        if (updateUserHash(username, ITERATIONS, newSalt, newHash)) {
                            System.out.println("Hash actualizado (rehash) con más iteraciones.");
                        }
                    }
                } else {
                    System.out.println("Credenciales inválidas.");
                }

            } else if ("3".equals(opt)) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }

    static void ensureDbExists() {
        File f = new File(DB_FILE);
        if (!f.exists()) {
            try {
                if (!f.createNewFile()) {
                    System.err.println("No se pudo crear la BD.");
                }
            } catch (IOException e) {
                System.err.println("Error creando BD: " + e.getMessage());
            }
        }
    }
}
