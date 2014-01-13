package model;

import br.ufal.cg.AutoDrawnableObject;
import javax.media.opengl.GL2;

public class Pulpito extends AutoDrawnableObject {

    public Pulpito(GL2 gl) {
        super(gl);
    }

    @Override
    protected String getTextureExtension() {
        return "jpg";
    }

    @Override
    protected String getTextureImg() {
        return "Altar.jpg";
    }

    @Override
    public void selfDraw(GL2 gl) {

        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_R, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
        
        texture.enable(gl);
        texture.bind(gl);
        
//      Parte de cima
        float[][] verticesL1 = {
            {-5f, -13f, 3.5f},
            {0f, -13f, 3.5f},
            {0f, -11f, 3.5f},
            {-5f, -11f, 3.5f}
        };
//      Parte da frente
        float[][] verticesL2 = {
            {-5f, -11f, 3.5f},
            {0f, -11f, 3.5f},
            {0f, -11f, 3f},
            {-5f, -11f, 3f}
        };
        float[][] verticesL3 = {
            verticesL2[3],
            verticesL2[2],
            {-0.5f, -11.5f, 0f},
            {-4.5f, -11.5f, 0f}
        };
//      Parte esquerda
        float[][] verticesL4 = {
            verticesL2[1],
            {0f, -13f, 3.5f},
            {0f, -13f, 3f},
            verticesL2[2]
        };
        float[][] verticesL5 = {
            verticesL4[3],
            verticesL4[2],
            {-0.5f, -12.5f, 0f},
            {-0.5f, -11.5f, 0f}
        };
//      Parte de trás
        float[][] verticesL6 = {
            {0f, -13f, 3f},
            {-5f, -13f, 3f},
            {-4.5f, -12.5f, 0f},
            {-0.5f, -12.5f, 0f}
        };
//      Parte direita
        float[][] verticesL7 = {
            {-5f, -13f, 3f},
            {-5f, -11f, 3f},
            {-4.5f, -11.5f, 0f},
            {-4.5f, -12.5f, 0f}
        };
        
        //Desenhar a parte de cima
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL1) {
            gl.glTexCoord2f(v[0]/10f, v[1]/10f);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        //Desenhar a parte da frente
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL2) {
            gl.glTexCoord2f(v[0]/10f, v[2]/10f);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL3) {
            gl.glTexCoord2f(v[0]/10f, v[2]/10f);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        //Desenhar a parte esquerda
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL4) {
            gl.glTexCoord2f(v[1]/10f, v[2]/10f);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL5) {
            gl.glTexCoord2f(v[1]/10f, v[2]/10f);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        //Desenhar a parte de trás
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL2) {
            gl.glTexCoord2f(v[0]/10f, v[2]/10f);
            gl.glVertex3f(v[0], v[1]-2f, v[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL6) {
            gl.glTexCoord2f(v[0]/10f, v[2]/10f);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        //Desenhar a parte direita
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL4) {
            gl.glTexCoord2f(v[1]/10f, v[2]/10f);
            gl.glVertex3f(v[0]-5f, v[1], v[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL7) {
            gl.glTexCoord2f(v[1]/10f, v[2]/10f);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        
    }

}
