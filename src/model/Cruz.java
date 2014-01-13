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
public class Cruz extends AutoDrawnableObject {

    public Cruz(GL2 gl) {
        super(gl);
    }

    @Override
    protected String getTextureExtension() {
        return "jpg";
    }

    @Override
    protected String getTextureImg() {
        return "FrontWall.jpg";
    }

    @Override
    public void selfDraw(GL2 gl) {
        
        texture.enable(gl);
        texture.bind(gl);
        
        gl.glColor3f(0, 1, 0);
        
//      Cruz da parede da frente
        float[][] verticesL1 = {
            {-2.6f, 20.85f, 19f},
            {-2.4f, 20.85f, 19f},
            {-2.4f, 20.85f, 15.8f},
            {-2.6f, 20.85f, 15.8f}
        };
        float[][] verticesL2 = {
            {-3.5f, 20.85f, 18f},
            {-1.5f, 20.85f, 18f},
            {-1.5f, 20.85f, 17.8f},
            {-3.5f, 20.85f, 17.8f}
        };
        float[][] verticesL3 = {
            verticesL1[0],
            verticesL1[1],
            verticesL1[2],
            verticesL1[3],
            verticesL1[0],
            
            verticesL2[0],
            verticesL2[1],
            verticesL2[2],
            verticesL2[3],
            verticesL2[0]
        };
        
        //Desenhar a parte da frente
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] vertice : verticesL1) {
            gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] vertice : verticesL2) {
            gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
        }
        gl.glEnd();
        //Desenhar a parte de trás
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] vertice : verticesL1) {
            gl.glVertex3f(vertice[0], vertice[1]-0.2f, vertice[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] vertice : verticesL2) {
            gl.glVertex3f(vertice[0], vertice[1]-0.2f, vertice[2]);
        }
        gl.glEnd();
        //Juntar as duas partes
        for (int i=0; i<verticesL3.length-1; ) {
            if (i==4) {
                i++;
            }
            
            float[] v1 = verticesL3[i++];
            float[] v2 = verticesL3[i];
            
            gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3f(v1[0], v1[1], v1[2]);
                gl.glVertex3f(v1[0], v1[1]-0.2f, v1[2]);
                gl.glVertex3f(v2[0], v2[1]-0.2f, v2[2]);
                gl.glVertex3f(v2[0], v2[1], v2[2]);
            gl.glEnd();
        }
        
//      Cruz da torre
        float[][] verticesL4 = {
            {6.9f, 18.85f, 28f},
            {7.1f, 18.85f, 28f},
            {7.1f, 18.85f, 24f},
            {6.9f, 18.85f, 24f}
        };
        float[][] verticesL5 = {
            {6f, 18.85f, 27f},
            {8f, 18.85f, 27f},
            {8f, 18.85f, 26.8f},
            {6f, 18.85f, 26.8f}
        };
        float[][] verticesL6 = {
            verticesL4[0],
            verticesL4[1],
            verticesL4[2],
            verticesL4[3],
            verticesL4[0],
            
            verticesL5[0],
            verticesL5[1],
            verticesL5[2],
            verticesL5[3],
            verticesL5[0]
        };
        
        //Desenhar a parte da frente
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] vertice : verticesL4) {
            gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] vertice : verticesL5) {
            gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
        }
        gl.glEnd();
        //Desenhar a parte de trás
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] vertice : verticesL4) {
            gl.glVertex3f(vertice[0], vertice[1]-0.2f, vertice[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] vertice : verticesL5) {
            gl.glVertex3f(vertice[0], vertice[1]-0.2f, vertice[2]);
        }
        gl.glEnd();
        //Juntar as duas partes
        for (int i=0; i<verticesL6.length-1; ) {
            if (i==4) {
                i++;
            }
            
            float[] v1 = verticesL6[i++];
            float[] v2 = verticesL6[i];
            
            gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3f(v1[0], v1[1], v1[2]);
                gl.glVertex3f(v1[0], v1[1]-0.2f, v1[2]);
                gl.glVertex3f(v2[0], v2[1]-0.2f, v2[2]);
                gl.glVertex3f(v2[0], v2[1], v2[2]);
            gl.glEnd();
        }
        
    }
    
}
