package model;

import javax.media.opengl.GL2;

/**
 *
 * @author Daniel Borges | Jário José
 */
public class Banco extends br.ufal.cg.AutoDrawnableObject {

    private int displayIndex = 3;

    public Banco(GL2 gl) {
        super(gl);
    }

    private void desenhaBanco(GL2 gl) {

        float[][] verticesPe = {
            {0f, 0f, 0f},
            {0f, 0f, 1.5f},
            {0f, -2.5f, 1.5f},
            {0f, -2.5f, 0f}
        };
        float[][] verticesSustento = {
            {0f, 0f, 0f},
            {0f, 0f, 3f},
            {0f, -0.5f, 3f},
            {0f, -0.75f, 0f}
        };
        float[][] verticesCostas = {
            {-4f, -0.5f, 1.75f},
            {-4f, -0.5f, 2.75f},
            {0f, -0.5f, 2.75f},
            {0f, -0.5f, 1.75f}
        };
        float[][] verticesAssento = {
            {-4f, -0.75f, 1.25f},
            {-4f, -2.25f, 1.25f},
            {0f, -2.25f, 1.25f},
            {0f, -0.75f, 1.25f}
        };

        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesPe) {
            gl.glTexCoord3f(v[0], v[1], v[2]);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesPe) {
            gl.glTexCoord3f(v[0], v[1], v[2]);
            gl.glVertex3f(v[0]-4, v[1], v[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesSustento) {
            gl.glTexCoord3f(v[0], v[1], v[2]);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesSustento) {
            gl.glTexCoord3f(v[0], v[1], v[2]);
            gl.glVertex3f(v[0]-4, v[1], v[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesCostas) {
            gl.glTexCoord3f(v[0], v[1], v[2]);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesAssento) {
            gl.glTexCoord3f(v[0], v[1], v[2]);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();

    }

    @Override
    protected String getTextureExtension() {
        return "jpg";
    }

    @Override
    protected String getTextureImg() {
        return "Banco.jpg";
    }

    @Override
    public void selfDraw(GL2 gl) {
        
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_R, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
        
        texture.enable(gl);
        texture.bind(gl);
        
        gl.glPushMatrix();
            gl.glTranslatef(4f, -4f, 0f);
            for (int i=0; i<7; i++) {
                desenhaBanco(gl);
                gl.glTranslatef(0f, 4f, 0f);
            }
        gl.glPopMatrix();
        
        gl.glPushMatrix();
            gl.glTranslatef(-5f, -4f, 0f);
            for (int i=0; i<7; i++) {
                desenhaBanco(gl);
                gl.glTranslatef(0f, 4f, 0f);
            }
        gl.glPopMatrix();
        
        gl.glPushMatrix();
            gl.glTranslatef(4.25f, -16f, 0f);
            gl.glRotatef(-90, 0, 0, 1);
            desenhaBanco(gl);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
            gl.glTranslatef(-9.25f, -12f, 0f);
            gl.glRotatef(90, 0, 0, 1);
//            gl.glTranslatef(-4f, 0f, 0f);
            desenhaBanco(gl);
        gl.glPopMatrix();
        
    }

}
