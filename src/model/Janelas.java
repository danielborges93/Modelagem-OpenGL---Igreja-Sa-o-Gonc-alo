/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import br.ufal.cg.AutoDrawnableObject;
import javax.media.opengl.GL2;

/**
 *
 * @author Daniel Borges | Jário José
 */
public class Janelas extends AutoDrawnableObject {

    public Janelas(GL2 gl) {
        super(gl);
    }

    @Override
    protected String getTextureExtension() {
        return "jpg";
    }

    @Override
    protected String getTextureImg() {
        return "Porta.jpg";
    }

    @Override
    public void selfDraw(GL2 gl) {
        
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_R, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
        
        texture.enable(gl);
        texture.bind(gl);
        
        gl.glColor3f(0, 1, 0);
        
//      Janelas
        float[][] verticesJanela1 = { //Parede equerda, lado direito
            {4.5f, 10f, 8},
            {4.5f, 10f, 5},
            {4.5f, 8f, 5},
            {4.5f, 8f, 8}
        };
        float[][] verticesJanela2 = { //Parede esquerda, lado esquerdo
            {4.5f, -13f, 8},
            {4.5f, -13f, 5},
            {4.5f, -15f, 5},
            {4.5f, -15f, 8}
        };
        float[][] verticesJanela3 = { //Parede direita, lado direito
            {-9.5f, 10f, 8},
            {-9.5f, 10f, 5},
            {-9.5f, 8f, 5},
            {-9.5f, 8f, 8}
        };
        float[][] verticesJanela4 = { //Parede direita, lado esquerdo
            {-9.5f, -13f, 8},
            {-9.5f, -13f, 5},
            {-9.5f, -15f, 5},
            {-9.5f, -15f, 8}
        };

        gl.glColor3f(0, 1, 0);

        gl.glPushMatrix();
        
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesJanela1) {
                gl.glTexCoord2f(vertice[1], vertice[2]);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesJanela2) {
                gl.glTexCoord2f(vertice[1], vertice[2]);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesJanela3) {
                gl.glTexCoord2f(vertice[1], vertice[2]);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesJanela4) {
                gl.glTexCoord2f(vertice[1], vertice[2]);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
        gl.glPopMatrix();
        
    }
    
}
