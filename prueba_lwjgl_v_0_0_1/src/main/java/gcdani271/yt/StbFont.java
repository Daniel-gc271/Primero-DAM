package gcdani271.yt;

import org.lwjgl.BufferUtils;
import org.lwjgl.stb.STBTTAlignedQuad;
import org.lwjgl.stb.STBTTBakedChar;
import org.lwjgl.system.MemoryStack;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.stb.STBTruetype.*;

public class StbFont {

    private final int texId;
    private final STBTTBakedChar.Buffer charData;
    private final int texW, texH;

    public StbFont(String resourcePath, int fontSize, int atlasSize) {
        this.texW = atlasSize;
        this.texH = atlasSize;

        ByteBuffer ttf = loadTTF(resourcePath);

        ByteBuffer bitmap = BufferUtils.createByteBuffer(texW * texH);
        charData = STBTTBakedChar.malloc(96); // ASCII 32..126

        int ok = stbtt_BakeFontBitmap(ttf, fontSize, bitmap, texW, texH, 32, charData);
        if (ok < 0) throw new RuntimeException("Error generando atlas STB");

        // Crear textura del atlas
        texId = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, texId);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_ALPHA, texW, texH, 0, GL_ALPHA, GL_UNSIGNED_BYTE, bitmap);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

        glBindTexture(GL_TEXTURE_2D, 0);
    }

    public void drawText(float x, float y, String text, float r, float g, float b, float a) {
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, texId);

        glColor4f(r, g, b, a);

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        try (MemoryStack stack = MemoryStack.stackPush()) {

            float[] xpos = { x };
            float[] ypos = { y };

            STBTTAlignedQuad quad = STBTTAlignedQuad.malloc(stack);

            glBegin(GL_QUADS);
            for (char c : text.toCharArray()) {
                if (c < 32 || c > 126) c = 32;
                stbtt_GetBakedQuad(charData, texW, texH, c - 32, xpos, ypos, quad, true);

                glTexCoord2f(quad.s0(), quad.t0());
                glVertex2f(quad.x0(), quad.y0());

                glTexCoord2f(quad.s1(), quad.t0());
                glVertex2f(quad.x1(), quad.y0());

                glTexCoord2f(quad.s1(), quad.t1());
                glVertex2f(quad.x1(), quad.y1());

                glTexCoord2f(quad.s0(), quad.t1());
                glVertex2f(quad.x0(), quad.y1());
            }
            glEnd();
        }

        glDisable(GL_BLEND);
        glBindTexture(GL_TEXTURE_2D, 0);
        glDisable(GL_TEXTURE_2D);
    }

    private ByteBuffer loadTTF(String resourcePath) {
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            if (is == null) throw new RuntimeException("No existe la fuente en " + resourcePath);

            var ch = Channels.newChannel(is);
            ByteBuffer buf = BufferUtils.createByteBuffer(1 << 20);
            while (ch.read(buf) != -1) ;
            buf.flip();
            return buf;

        } catch (Exception e) {
            throw new RuntimeException("Error cargando TTF: " + resourcePath, e);
        }
    }
}