# Setup hosting en casa #
## Panel (pterodactyl) ##
### Instalar dependencias ###
```
sudo apt update
sudo apt install -y curl unzip git mariadb-server redis-server
sudo apt install -y nginx
sudo apt install -y php8.3 php8.3-{cli,common,gd,mysql,mbstring,bcmath,fpm,curlzip,xml}  
```
### Crear base de datos ###
```
sudo mysql
CREATE DATABASE panel;
CREATE USER 'ptero'@'127.0.0.1' IDENTIFIED BY 'passwordsegura';
GRANT ALL PRIVILEGES ON panel.* TO 'ptero'@'127.0.0.1';
FLUSH PRIVILEGES;
exit;
```
### Descargar panel
```
cd /var/www
sudo mkdir pterodactyl
sudo chown -R $USER:$USER pterodactyl
cd pterodactyl
curl -Lo panel.tar.gz https://github.com/pterodactyl/panel/releases/latest/download/panel.tar.gz
tar -xzvf panel.tar.gz
composer install --no-dev --optimize-autoloader
```
### Configuracion inicial del panel
asocia la base credenciales cache etc
personalmente redis me ha funcionado muy bien
```
php artisan p:environment:setup
php artisan p:environment:database
php artisan migrate --seed
```
### Configurar tareas en segundo plano del panel
ejecutar:
```
crontab -e
```
seleccionar un editor (nano es mi eleccion por excelencia)
pegar en la ultima linea
```
* * * * * php /var/www/pterodactyl/artisan schedule:run >> /dev/null 2>&1
```
ejecutar
```
sudo nano /etc/systemd/system/pteroq.service
```
pegar el codigo
```
# Pterodactyl Queue Worker File
# ----------------------------------

[Unit]
Description=Pterodactyl Queue Worker
After=redis-server.service

[Service]
# On some systems the user and group might be different.
# Some systems use `apache` or `nginx` as the user and group.
User=www-data
Group=www-data
Restart=always
ExecStart=/usr/bin/php /var/www/pterodactyl/artisan queue:work --queue=high,standard,low --sleep=3 --tries=3
StartLimitInterval=180
StartLimitBurst=30
RestartSec=5s

[Install]
WantedBy=multi-user.target
```
### Activar los servicios requeridos al iniciar el sistema
```
sudo systemctl enable --now redis-server
sudo systemctl enable --now pteroq.service
```
#### Permisos de las carpetas
www-data es el usuario por excelencia de los archivos referentes a  páginas/aplicaciones web en ubuntu

```
sudo chown -R www-data:www-data /var/www/pterodactyl
```
#### Crear al primer usuario
Asegura tener al menos un usuario administrador
```
php artisan p:user:make
```
### Configurar el host de la web del panel (nginx)
Abrir el editor de texto
```
sudo nano /etc/nginx/sites-available/pterodactyl.conf
```
Pegar la configuracion: (solo http)
```
server {
    listen 80;
    server_name 192.168.1.50;

    root /var/www/pterodactyl/public;

    index index.php;

    location / {
        try_files $uri $uri/ /index.php?$query_string;
    }

    location ~ \.php$ {
        include snippets/fastcgi-php.conf;
        fastcgi_pass unix:/run/php/php8.3-fpm.sock;
    }

    location ~* \.(js|css|png|jpg|jpeg|gif|ico)$ {
        try_files $uri =404;
    }
}
```
