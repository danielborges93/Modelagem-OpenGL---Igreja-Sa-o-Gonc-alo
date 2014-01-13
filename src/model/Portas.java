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
public class Portas extends AutoDrawnableObject {
    
    private boolean isOpen = false;
    private float angulo = 0;

    public Portas(GL2 gl) {
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
        
//      Porta da frente
        float[][] verticesL1 = { //Parte de cima
            {-0.5f, 20.75f, 8},
            {-0.75f, 20.75f, 8.97f},
            {-1f, 20.75f, 9.3f},
            {-1.25f, 20.75f, 9.55f},
            {-1.5f, 20.75f, 9.7f},
            {-1.75f, 20.75f, 9.85f},
            {-2f, 20.75f, 9.9f},
            {-2.25f, 20.75f, 9.98f},
            {-2.5f, 20.75f, 10},
            {-2.75f, 20.75f, 9.98f},
            {-3f, 20.75f, 9.9f},
            {-3.25f, 20.75f, 9.85f},
            {-3.5f, 20.75f, 9.7f},
            {-3.75f, 20.75f, 9.55f},
            {-4f, 20.75f, 9.3f},
            {-4.25f, 20.75f, 8.97f},
            {-4.5f, 20.75f, 8}
        };
        float[][] verticesL2 = { //As duas pontas de cima
            verticesL1[0],
            verticesL1[16]
        };
        float[][] verticesL3 = { //Porta direita
            verticesL2[1],
            {-2.5f, 20.75f, 8},
            {-2.5f, 20.75f, 0},
            {-4.5f, 20.75f, 0}
        };
        float[][] verticesL4 = { //Porta esquerda
            {-2.5f, 20.75f, 8},
            verticesL2[0],
            {-0.5f, 20.75f, 0},
            {-2.5f, 20.75f, 0}
        };
        
        //Desenhar a parte da frente da parte de cima
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL1) {
            gl.glTexCoord2f(v[0], v[2]);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        //Desenhar a parte de trás
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL1) {
            gl.glTexCoord2f(v[0], v[2]);
            gl.glVertex3f(v[0], v[1]-0.5f, v[2]);
        }
        gl.glEnd();
        //Juntar as partes
        gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3f(verticesL2[0][0], verticesL2[0][1], verticesL2[0][2]);
            gl.glVertex3f(verticesL2[1][0], verticesL2[1][1], verticesL2[1][2]);
            gl.glVertex3f(verticesL2[1][0], verticesL2[1][1]-0.5f, verticesL2[1][2]);
            gl.glVertex3f(verticesL2[0][0], verticesL2[0][1]-0.5f, verticesL2[0][2]);
        gl.glEnd();
        //Desenhar os detalhes da porta
        gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3f(verticesL2[0][0], verticesL2[0][1]+0.25f, verticesL2[0][2]+0.25f);
            gl.glVertex3f(verticesL2[1][0], verticesL2[1][1]+0.25f, verticesL2[1][2]+0.25f);
            gl.glVertex3f(verticesL2[1][0], verticesL2[1][1], verticesL2[1][2]+0.25f);
            gl.glVertex3f(verticesL2[0][0], verticesL2[0][1], verticesL2[0][2]+0.25f);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3f(verticesL2[0][0], verticesL2[0][1]+0.25f, verticesL2[0][2]+0.25f);
            gl.glVertex3f(verticesL2[1][0], verticesL2[1][1]+0.25f, verticesL2[1][2]+0.25f);
            gl.glVertex3f(verticesL2[1][0], verticesL2[1][1], verticesL2[1][2]);
            gl.glVertex3f(verticesL2[0][0], verticesL2[0][1], verticesL2[0][2]);
        gl.glEnd();
        //Desenhar a porta direita
        gl.glPushMatrix();
            gl.glTranslatef(verticesL2[1][0], verticesL2[1][1], 0f);
            gl.glRotatef(angulo, 0, 0, 1);
            gl.glTranslatef(-verticesL2[1][0], -verticesL2[1][1], 0f);
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] v : verticesL3) {
                gl.glTexCoord2f(v[0], v[2]);
                gl.glVertex3f(v[0], v[1]-0.01f, v[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] v : verticesL3) {
                gl.glTexCoord2f(v[0], v[2]);
                gl.glVertex3f(v[0], v[1]-0.25f, v[2]);
            }
            gl.glEnd();
            for (int i=0; i<verticesL3.length; i++) {
                
                int j = i+1;
                if (j == 4) j = 0;

                float[] v1 = verticesL3[i];
                float[] v2 = verticesL3[j];

                gl.glBegin(GL2.GL_POLYGON);
                    gl.glVertex3f(v1[0], v1[1], v1[2]);
                    gl.glVertex3f(v1[0], v1[1]-0.25f, v1[2]);
                    gl.glVertex3f(v2[0], v2[1]-0.25f, v2[2]);
                    gl.glVertex3f(v2[0], v2[1], v2[2]);
                gl.glEnd();
            }
        gl.glPopMatrix();
        //Desenhar a porta esquerda
        gl.glPushMatrix();
            gl.glTranslatef(verticesL2[0][0], verticesL2[0][1], 0f);
            gl.glRotatef(-angulo, 0, 0, 1);
            gl.glTranslatef(-verticesL2[0][0], -verticesL2[0][1], 0f);
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] v : verticesL4) {
                gl.glTexCoord2f(v[0], v[2]);
                gl.glVertex3f(v[0], v[1]-0.01f, v[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] v : verticesL4) {
                gl.glTexCoord2f(v[0], v[2]);
                gl.glVertex3f(v[0], v[1]-0.25f, v[2]);
            }
            gl.glEnd();
            for (int i=0; i<verticesL4.length; i++) {
                
                int j = i+1;
                if (j == 4) j = 0;

                float[] v1 = verticesL4[i];
                float[] v2 = verticesL4[j];

                gl.glBegin(GL2.GL_POLYGON);
                    gl.glVertex3f(v1[0], v1[1], v1[2]);
                    gl.glVertex3f(v1[0], v1[1]-0.25f, v1[2]);
                    gl.glVertex3f(v2[0], v2[1]-0.25f, v2[2]);
                    gl.glVertex3f(v2[0], v2[1], v2[2]);
                gl.glEnd();
            }
        gl.glPopMatrix();
        
//      Porta da torre
        float[][] verticesL5 = {
            {8.5f, 16.5f, 10f},
            {8.25f, 16.5f, 10.95f},
            {8f, 16.5f, 11.32f},
            {7.75f, 16.5f, 11.55f},
            {7.5f, 16.5f, 11.73f},
            {7.25f, 16.5f, 11.86f},
            {7f, 16.5f, 11.93f},
            {6.75f, 16.5f, 11.98f},
            {6.5f, 16.5f, 12},
            {6.25f, 16.5f, 11.98f},
            {6f, 16.5f, 11.93f},
            {5.75f, 16.5f, 11.86f},
            {5.5f, 16.5f, 11.73f},
            {5.25f, 16.5f, 11.55f},
            {5f, 16.5f, 11.32f},
            {4.75f, 16.5f, 10.95f},
            {4.5f, 16.5f, 10}
        };
        float[][] verticesL6 = {
            verticesL5[0],
            verticesL5[16],
            {4.5f, 16.5f, 1.5f},
            {8.5f, 16.5f, 1.5f}
        };
        
        //Desenhar a parte de cima
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL5) {
            gl.glTexCoord2f(v[0], v[2]);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL6) {
            gl.glTexCoord2f(v[0], v[2]);
            gl.glVertex3f(v[0], v[1], v[2]-0.05f);
        }
        gl.glEnd();
    }
    
    public void abrir() {
        
        new Thread(new Runnable() {

            @Override
            public void run() {
                if (isOpen) {
                    return;
                }
                isOpen = true;
                
                for (int i=0; i<90; i++) {
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    angulo++;
                }
            }
            
        }).start();

    }
    
    public void fechar() {
        
        new Thread(new Runnable() {

            @Override
            public void run() {
                if (!isOpen) {
                    return;
                }
                isOpen = false;
                
                for (int i=0; i<90; i++) {
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    angulo--;
                }
            }
            
        }).start();

    }
    
}
