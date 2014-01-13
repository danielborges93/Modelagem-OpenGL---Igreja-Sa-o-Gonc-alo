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
public class Torre extends AutoDrawnableObject {

    public Torre(GL2 gl) {
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
        
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_R, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
        
        texture.enable(gl);
        texture.bind(gl);
        
        gl.glColor3f(1, 1, 1);
        
//        GLUT glut = new GLUT();
//        
//        gl.glPushMatrix();
//            gl.glScalef(5, 5, 15);
//            gl.glTranslatef(1.52f, 3.75f, 0.5f);
//            glut.glutSolidCube(1);
//        gl.glPopMatrix();
//        
//        gl.glPushMatrix();
//            gl.glScalef(5, 0.6f, 6);
//            gl.glTranslatef(1.52f, 34.95f, 3f);
//            glut.glutSolidCube(1);
//        gl.glPopMatrix();
//        
//        gl.glPushMatrix();
//            gl.glScalef(0.6f, 4.99f, 6);
//            gl.glTranslatef(16.34f, 3.759f, 3f);
//            glut.glutSolidCube(1);
//        gl.glPopMatrix();
//        
//        gl.glPushMatrix();
//            gl.glScalef(5, 0.6f, 6);
//            gl.glTranslatef(1.52f, 27.585f, 3f);
//            glut.glutSolidCube(1);
//        gl.glPopMatrix();
//        
//        gl.glPushMatrix();
//            gl.glScalef(0.6f, 4.99f, 6);
//            gl.glTranslatef(8.99f, 3.759f, 3f);
//            glut.glutSolidCube(1);
//        gl.glPopMatrix();
//        
//        gl.glPushMatrix();
//            
//        gl.glPopMatrix();
        
        //Parte de baixo da torre
        float[][] verticesL1 = { //Lado da frente
            {4.5f, 21.25f, 13},
            {4.5f, 21.25f, 0},
            {9.5f, 21.25f, 0},
            {9.5f, 21.25f, 13}
        };
        float[][] verticesL2 = { //Lado esquerdo
            {9.5f, 21.25f, 13},
            {9.5f, 21.25f, 0},
            {9.5f, 16.25f, 0},
            {9.5f, 16.25f, 13}
        };
        float[][] verticesL3 = { //Primeira parte do lado de trás (lado direito)
            {9.5f, 16.25f, 13},
            {9.5f, 16.25f, 0},
            {8.5f, 16.25f, 0},
            {8.5f, 16.25f, 1.5f},
            {8.5f, 16.25f, 10f},
            {8.25f, 16.25f, 10.95f},
            {8f, 16.25f, 11.32f},
            {7.75f, 16.25f, 11.55f},
            {7.5f, 16.25f, 11.73f},
            {7.25f, 16.25f, 11.86f},
            {7f, 16.25f, 11.93f},
            {6.75f, 16.25f, 11.98f},
            {6.5f, 16.25f, 12f},
            {6.5f, 16.25f, 13f}
        };
        float[][] verticesL4 = { //Segunda parte do lado de trás (lado esquerdo)
            {4.5f, 16.25f, 13},
            {6.5f, 16.25f, 13},
            {6.5f, 16.25f, 12},
            {6.25f, 16.25f, 11.98f},
            {6f, 16.25f, 11.93f},
            {5.75f, 16.25f, 11.86f},
            {5.5f, 16.25f, 11.73f},
            {5.25f, 16.25f, 11.55f},
            {5f, 16.25f, 11.32f},
            {4.75f, 16.25f, 10.95f},
            {4.5f, 16.25f, 10}
        };
        float[][] verticesArco1 = { //Arco do lado de trás da base
            //3 a 12 de L3
            verticesL3[3],
            verticesL3[4],
            verticesL3[5],
            verticesL3[6],
            verticesL3[7],
            verticesL3[8],
            verticesL3[9],
            verticesL3[10],
            verticesL3[11],
            verticesL3[12],
            //3 a 10 de L4
            verticesL4[3],
            verticesL4[4],
            verticesL4[5],
            verticesL4[6],
            verticesL4[7],
            verticesL4[8],
            verticesL4[9],
            verticesL4[10]
        };
        float[][] verticesL5 = { //Degraus
            {9.5f, 17.25f, 3f},
            {9.5f, 17.25f, 0f},
            {9.5f, 15.25f, 0f},
            {9.5f, 15.25f, 3f},
            
            {9.5f, 15.25f, 2f},
            {9.5f, 15.25f, 0f},
            {9.5f, 14.25f, 0f},
            {9.5f, 14.25f, 2f},
            
            {9.5f, 14.25f, 1f},
            {9.5f, 14.25f, 0f},
            {9.5f, 13.25f, 0f},
            {9.5f, 13.25f, 1f}
        };
        float[][] verticesL6 = { //Primeira parte do lado da frente do topo (lado direito)
            {4.5f, 21.25f, 20},
            verticesL1[0],
            {6f, 21.25f, 13},
            {6f, 21.25f, 16.5f},
            
            {6.25f, 21.25f, 17.16f}, //
            {6.5f, 21.25f, 17.36f}, //
            {6.75f, 21.25f, 17.47f}, //
            
            {7f, 21.25f, 17.5f},
            {7f, 21.25f, 20}
        };
        float[][] verticesL7 = { //Segunda parte do lado da frente do topo (lado esquerdo)
            {9.5f, 21.25f, 20f},
            {7f, 21.25f, 20f},
            {7f, 21.25f, 17.5f},
            
            {7.25f, 21.25f, 17.47f}, //
            {7.5f, 21.25f, 17.36f}, //
            {7.75f, 21.25f, 17.16f}, //
            
            {8f, 21.25f, 16.5f},
            {8f, 21.25f, 13f},
            {9.5f, 21.25f, 13f}
        };
        float[][] verticesArco2 = { //Arco da parte da frente
            //2 a 7 de L6
            verticesL6[2],
            verticesL6[3],
            verticesL6[4],
            verticesL6[5],
            verticesL6[6],
            verticesL6[7],
            //2 a 7 de L7
            verticesL7[2],
            verticesL7[3],
            verticesL7[4],
            verticesL7[5],
            verticesL7[6],
            verticesL7[7],
            //Parte de baixo
//            verticesL7[7],
//            verticesL6[2]
        };
        float[][] verticesL8 = { //Primeira parte do lado esquerdo do topo (lado direito)
            {9.5f, 21.25f, 20f},
            {9.5f, 21.25f, 13f},
            {9.5f, 19.75f, 13f},
            {9.5f, 19.75f, 16.5f},
            
            {9.5f, 19.5f, 17.16f}, //
            {9.5f, 19.25f, 17.36f}, //
            {9.5f, 19f, 17.46f}, //
            
            {9.5f, 18.75f, 17.5f},
            {9.5f, 18.75f, 20f}
        };
        float[][] verticesL9 = { //Segunda parte do lado esquerdo do topo (lado esquerdo)
            {9.5f, 16.25f, 20f},
            {9.5f, 18.75f, 20f},
            {9.5f, 18.75f, 17.5f},
            
            {9.5f, 18.5f, 17.46f}, //
            {9.5f, 18.25f, 17.36f}, //
            {9.5f, 18f, 17.16f}, //
            
            {9.5f, 17.75f, 16.5f},
            {9.5f, 17.75f, 13f},
            {9.5f, 16.25f, 13f}
        };
        float[][] verticesArco3 = { //Arco da parte esquerda
            //2 a 7 de L8
            verticesL8[2],
            verticesL8[3],
            verticesL8[4],
            verticesL8[5],
            verticesL8[6],
            verticesL8[7],
            //2 a 7 de L9
            verticesL9[2],
            verticesL9[3],
            verticesL9[4],
            verticesL9[5],
            verticesL9[6],
            verticesL9[7],
            //Parte de baixo
//            verticesL9[7],
//            verticesL8[2]
        };
        float[][] verticesL10 = { //Lado de trás
            verticesL9[0],
            verticesL9[8],
            {4.5f, 16.25f, 13f},
            {4.5f, 16.25f, 20f}
        };
        float[][] verticesL11 = { //Lado direito
            verticesL10[3],
            verticesL10[2],
            verticesL6[1],
            verticesL6[0]
        };
        float[][] verticesL12 = { //Detalhes da parede
            {4.5f, 21.25f},
            {9.5f, 21.25f},
            {9.5f, 16.25f},
            {4.5f, 16.25f}
        };
        float[][] piramideL1 = {
            {5.25f, 20.5f, 22f},
            verticesL6[0],
            {6f, 21.25f, 20f},
            {6f, 19.75f, 20f},
            {4.5f, 19.75f, 20f},
            verticesL6[0]
        };
        float[][] piramideL2 = {
            {8.75f, 20.5f, 22f},
            {8f, 21.25f, 20f},
            {9.5f, 21.25f, 20f},
            {9.5f, 19.75f, 20f},
            {8f, 19.75f, 20f},
            {8f, 21.25f, 20f}
        };
        float[][] piramideL3 = {
            {8.75f, 17f, 22f},
            {9.5f, 16.25f, 20f},
            {8f, 16.25f, 20f},
            {8f, 17.75f, 20f},
            {9.5f, 17.75f, 20f},
            {9.5f, 16.25f, 20f}
        };
        float[][] piramideL4 = {
            {5.25f, 17f, 22f},
            {6f, 16.25f, 20f},
            {4.5f, 16.25f, 20f},
            {4.5f, 17.75f, 20f},
            {6f, 17.75f, 20f},
            {6f, 16.25f, 20f}
        };
        float[][] piramideL5 = {
            {7f, 18.75f, 25f},
            {6f, 19.75f, 20f},
            {8f, 19.75f, 20f},
            {8f, 17.75f, 20f},
            {6f, 17.75f, 20f},
            {6f, 19.75f, 20f}
        };
        
        gl.glPushMatrix();
            //Desenhar o lado da frente da base
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL1) {
                gl.glTexCoord2f(vertice[0]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            //Desenhar o lado esquerdo da base
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL2) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            //Desenhar a parte de fora da prmeira parte do lado de trás
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL3.length-1; i++) {
                gl.glTexCoord2f(verticesL3[0][0]/10f, verticesL3[0][2]/10f);
                gl.glVertex3f(verticesL3[0][0], verticesL3[0][1], verticesL3[0][2]);
                gl.glTexCoord2f(verticesL3[i][0]/10f, verticesL3[i][2]/10f);
                gl.glVertex3f(verticesL3[i][0], verticesL3[i][1], verticesL3[i][2]);
                gl.glTexCoord2f(verticesL3[i+1][0]/10f, verticesL3[i+1][2]/10f);
                gl.glVertex3f(verticesL3[i+1][0], verticesL3[i+1][1], verticesL3[i+1][2]);
            }
            gl.glEnd();
            //Desenhar a parte de fora da segunda parte do lado de trás
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL4.length-1; i++) {
                gl.glTexCoord2f(verticesL4[0][0]/10f, verticesL4[0][2]/10f);
                gl.glVertex3f(verticesL4[0][0], verticesL4[0][1], verticesL4[0][2]);
                gl.glTexCoord2f(verticesL4[i][0]/10f, verticesL4[i][2]/10f);
                gl.glVertex3f(verticesL4[i][0], verticesL4[i][1], verticesL4[i][2]);
                gl.glTexCoord2f(verticesL4[i+1][0]/10f, verticesL4[i+1][2]/10f);
                gl.glVertex3f(verticesL4[i+1][0], verticesL4[i+1][1], verticesL4[i+1][2]);
            }
            gl.glEnd();
            //Desenhar a parte de dentro da prmeira parte do lado de trás
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL3.length-1; i++) {
                gl.glTexCoord2f(verticesL3[0][0]/10f, verticesL3[0][2]/10f);
                gl.glVertex3f(verticesL3[0][0], verticesL3[0][1]+1, verticesL3[0][2]);
                gl.glTexCoord2f(verticesL3[i][0]/10f, verticesL3[i][2]/10f);
                gl.glVertex3f(verticesL3[i][0], verticesL3[i][1]+1, verticesL3[i][2]);
                gl.glTexCoord2f(verticesL3[i+1][0]/10f, verticesL3[i+1][2]/10f);
                gl.glVertex3f(verticesL3[i+1][0], verticesL3[i+1][1]+1, verticesL3[i+1][2]);
            }
            gl.glEnd();
            //Desenhar a parte de dentro da segunda parte do lado de trás
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL4.length-1; i++) {
                gl.glTexCoord2f(verticesL4[0][0]/10f, verticesL4[0][2]/10f);
                gl.glVertex3f(verticesL4[0][0], verticesL4[0][1]+1, verticesL4[0][2]);
                gl.glTexCoord2f(verticesL4[i][0]/10f, verticesL4[i][2]/10f);
                gl.glVertex3f(verticesL4[i][0], verticesL4[i][1]+1, verticesL4[i][2]);
                gl.glTexCoord2f(verticesL4[i+1][0]/10f, verticesL4[i+1][2]/10f);
                gl.glVertex3f(verticesL4[i+1][0], verticesL4[i+1][1]+1, verticesL4[i+1][2]);
            }
            gl.glEnd();
            //Juntar as partes
            for (int i=0; i<verticesArco1.length-1; i++) {
                float[] v1 = verticesArco1[i];
                float[] v2 = verticesArco1[i+1];
                
                
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord2f(v1[1]/10f, v1[2]/10f);
                    gl.glVertex3f(v1[0], v1[1], v1[2]);
                    gl.glTexCoord2f((v1[1]+1)/10f, v1[2]/10f);
                    gl.glVertex3f(v1[0], v1[1]+1, v1[2]);
                    gl.glTexCoord2f((v2[1]+1)/10f, v2[2]/10f);
                    gl.glVertex3f(v2[0], v2[1]+1, v2[2]);
                    gl.glTexCoord2f(v2[1]/10f, v2[2]/10f);
                    gl.glVertex3f(v2[0], v2[1], v2[2]);
                gl.glEnd();
            }
            //Desenhar os degraus
            for (int i=0; i<verticesL5.length; ) {
                float[] v1 = verticesL5[i++];
                float[] v2 = verticesL5[i++];
                float[] v3 = verticesL5[i++];
                float[] v4 = verticesL5[i++];
                
                //Parte direita
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord2f(v1[1]/10f, v1[2]/10f);
                    gl.glVertex3f(v1[0], v1[1], v1[2]);
                    gl.glTexCoord2f(v2[1]/10f, v2[2]/10f);
                    gl.glVertex3f(v2[0], v2[1], v2[2]);
                    gl.glTexCoord2f(v3[1]/10f, v3[2]/10f);
                    gl.glVertex3f(v3[0], v3[1], v3[2]);
                    gl.glTexCoord2f(v4[1]/10f, v4[2]/10f);
                    gl.glVertex3f(v4[0], v4[1], v4[2]);
                gl.glEnd();
                //Parte da frente
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord2f(v4[0]/10f, v4[2]/10f);
                    gl.glVertex3f(v4[0], v4[1], v4[2]);
                    gl.glTexCoord2f(v3[0]/10f, v3[2]/10f);
                    gl.glVertex3f(v3[0], v3[1], v3[2]);
                    gl.glTexCoord2f((v3[0]-5)/10f, v3[2]/10f);
                    gl.glVertex3f(v3[0]-5, v3[1], v3[2]);
                    gl.glTexCoord2f((v4[0]-5)/10f, v4[2]/10f);
                    gl.glVertex3f(v4[0]-5, v4[1], v4[2]);
                gl.glEnd();
                //Parte de cima
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord2f((v1[0]-5)/10f, v1[1]/10f);
                    gl.glVertex3f(v1[0]-5, v1[1], v1[2]);
                    gl.glTexCoord2f(v1[0]/10f, v1[1]/10f);
                    gl.glVertex3f(v1[0], v1[1], v1[2]);
                    gl.glTexCoord2f(v4[0]/10f, v4[1]/10f);
                    gl.glVertex3f(v4[0], v4[1], v4[2]);
                    gl.glTexCoord2f((v4[0]-5)/10f, v4[1]/10f);
                    gl.glVertex3f(v4[0]-5, v4[1], v4[2]);
                gl.glEnd();
            }
            //Desenhar o lado de fora do lado direito da parte da frente do topo
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL6.length-1; i++) {
                gl.glTexCoord2f(verticesL6[0][0]/10f, verticesL6[0][2]/10f);
                gl.glVertex3f(verticesL6[0][0], verticesL6[0][1], verticesL6[0][2]);
                gl.glTexCoord2f(verticesL6[i][0]/10f, verticesL6[i][2]/10f);
                gl.glVertex3f(verticesL6[i][0], verticesL6[i][1], verticesL6[i][2]);
                gl.glTexCoord2f(verticesL6[i+1][0]/10f, verticesL6[i+1][2]/10f);
                gl.glVertex3f(verticesL6[i+1][0], verticesL6[i+1][1], verticesL6[i+1][2]);
            }
            gl.glEnd();
            //Desenhar o lado de fora do lado esquerdo da parte da frente do topo
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL7.length-1; i++) {
                gl.glTexCoord2f(verticesL7[0][0]/10f, verticesL7[0][2]/10f);
                gl.glVertex3f(verticesL7[0][0], verticesL7[0][1], verticesL7[0][2]);
                gl.glTexCoord2f(verticesL7[i][0]/10f, verticesL7[i][2]/10f);
                gl.glVertex3f(verticesL7[i][0], verticesL7[i][1], verticesL7[i][2]);
                gl.glTexCoord2f(verticesL7[i+1][0]/10f, verticesL7[i+1][2]/10f);
                gl.glVertex3f(verticesL7[i+1][0], verticesL7[i+1][1], verticesL7[i+1][2]);
            }
            gl.glEnd();
            //Desenhar o lado de dentro do lado direito da parte da frente do topo
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL6.length-1; i++) {
                gl.glTexCoord2f(verticesL6[0][0]/10f, verticesL6[0][2]/10f);
                gl.glVertex3f(verticesL6[0][0], verticesL6[0][1]-1, verticesL6[0][2]);
                gl.glTexCoord2f(verticesL6[i][0]/10f, verticesL6[i][2]/10f);
                gl.glVertex3f(verticesL6[i][0], verticesL6[i][1]-1, verticesL6[i][2]);
                gl.glTexCoord2f(verticesL6[i+1][0]/10f, verticesL6[i+1][2]/10f);
                gl.glVertex3f(verticesL6[i+1][0], verticesL6[i+1][1]-1, verticesL6[i+1][2]);
            }
            gl.glEnd();
            //Desenhar o lado de dentro do lado esquerdo da parte da frente do topo
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL7.length-1; i++) {
                gl.glTexCoord2f(verticesL7[0][0]/10f, verticesL7[0][2]/10f);
                gl.glVertex3f(verticesL7[0][0], verticesL7[0][1]-1, verticesL7[0][2]);
                gl.glTexCoord2f(verticesL7[i][0]/10f, verticesL7[i][2]/10f);
                gl.glVertex3f(verticesL7[i][0], verticesL7[i][1]-1, verticesL7[i][2]);
                gl.glTexCoord2f(verticesL7[i+1][0]/10f, verticesL7[i+1][2]/10f);
                gl.glVertex3f(verticesL7[i+1][0], verticesL7[i+1][1]-1, verticesL7[i+1][2]);
            }
            gl.glEnd();
            //Juntar as partes
            for (int i=0; i<verticesArco2.length-1; i++) {
                float[] v1 = verticesArco2[i];
                float[] v2 = verticesArco2[i+1];
                
                
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord2f(v1[1]/10f, v1[2]/10f);
                    gl.glVertex3f(v1[0], v1[1], v1[2]);
                    gl.glTexCoord2f((v1[1]-1)/10f, v1[2]/10f);
                    gl.glVertex3f(v1[0], v1[1]-1, v1[2]);
                    gl.glTexCoord2f((v2[1]-1)/10f, v2[2]/10f);
                    gl.glVertex3f(v2[0], v2[1]-1, v2[2]);
                    gl.glTexCoord2f(v2[1]/10f, v2[2]/10f);
                    gl.glVertex3f(v2[0], v2[1], v2[2]);
                gl.glEnd();
            }
            //Desenhar o lado de fora do lado direito da parte esquerda do topo
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL8.length-1; i++) {
                gl.glTexCoord2f(verticesL8[0][1]/10f, verticesL8[0][2]/10f);
                gl.glVertex3f(verticesL8[0][0], verticesL8[0][1], verticesL8[0][2]);
                gl.glTexCoord2f(verticesL8[i][1]/10f, verticesL8[i][2]/10f);
                gl.glVertex3f(verticesL8[i][0], verticesL8[i][1], verticesL8[i][2]);
                gl.glTexCoord2f(verticesL8[i+1][1]/10f, verticesL8[i+1][2]/10f);
                gl.glVertex3f(verticesL8[i+1][0], verticesL8[i+1][1], verticesL8[i+1][2]);
            }
            gl.glEnd();
            //Desenhar o lado de fora do lado esquerdo da parte esquerda do topo
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL9.length-1; i++) {
                gl.glTexCoord2f(verticesL9[0][1]/10f, verticesL9[0][2]/10f);
                gl.glVertex3f(verticesL9[0][0], verticesL9[0][1], verticesL9[0][2]);
                gl.glTexCoord2f(verticesL9[i][1]/10f, verticesL9[i][2]/10f);
                gl.glVertex3f(verticesL9[i][0], verticesL9[i][1], verticesL9[i][2]);
                gl.glTexCoord2f(verticesL9[i+1][1]/10f, verticesL9[i+1][2]/10f);
                gl.glVertex3f(verticesL9[i+1][0], verticesL9[i+1][1], verticesL9[i+1][2]);
            }
            gl.glEnd();
            //Desenhar o lado de dentro do lado direito da parte esquerda do topo
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL8.length-1; i++) {
                gl.glTexCoord2f(verticesL8[0][1]/10f, verticesL8[0][2]/10f);
                gl.glVertex3f(verticesL8[0][0]-1, verticesL8[0][1], verticesL8[0][2]);
                gl.glTexCoord2f(verticesL8[i][1]/10f, verticesL8[i][2]/10f);
                gl.glVertex3f(verticesL8[i][0]-1, verticesL8[i][1], verticesL8[i][2]);
                gl.glTexCoord2f(verticesL8[i+1][1]/10f, verticesL8[i+1][2]/10f);
                gl.glVertex3f(verticesL8[i+1][0]-1, verticesL8[i+1][1], verticesL8[i+1][2]);
            }
            gl.glEnd();
            //Desenhar o lado de dentro do lado esquerdo da parte esquerda do topo
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL9.length-1; i++) {
                gl.glTexCoord2f(verticesL9[0][1]/10f, verticesL9[0][2]/10f);
                gl.glVertex3f(verticesL9[0][0]-1, verticesL9[0][1], verticesL9[0][2]);
                gl.glTexCoord2f(verticesL9[i][1]/10f, verticesL9[i][2]/10f);
                gl.glVertex3f(verticesL9[i][0]-1, verticesL9[i][1], verticesL9[i][2]);
                gl.glTexCoord2f(verticesL9[i+1][1]/10f, verticesL9[i+1][2]/10f);
                gl.glVertex3f(verticesL9[i+1][0]-1, verticesL9[i+1][1], verticesL9[i+1][2]);
            }
            gl.glEnd();
            //Juntar as partes
            for (int i=0; i<verticesArco3.length-1; i++) {
                float[] v1 = verticesArco3[i];
                float[] v2 = verticesArco3[i+1];
                
                
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord2f(v1[0]/10f, v1[2]/10f);
                    gl.glVertex3f(v1[0], v1[1], v1[2]);
                    gl.glTexCoord2f((v1[0]-1)/10f, v1[2]/10f);
                    gl.glVertex3f(v1[0]-1, v1[1], v1[2]);
                    gl.glTexCoord2f((v2[0]-1)/10f, v2[2]/10f);
                    gl.glVertex3f(v2[0]-1, v2[1], v2[2]);
                    gl.glTexCoord2f(v2[0]/10f, v2[2]/10f);
                    gl.glVertex3f(v2[0], v2[1], v2[2]);
                gl.glEnd();
            }
            //Desenhar o lado de fora da parte de trás
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL10) {
                gl.glTexCoord2f(vertice[0]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            //Desenhar o lado de dentro da parte de trás
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL10) {
                gl.glTexCoord2f(vertice[0]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1]+1, vertice[2]);
            }
            gl.glEnd();
            //Desenhar a parte direita
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL11) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            //Desenhar os detalhes da parede
            gl.glBegin(GL2.GL_POLYGON);
                gl.glTexCoord2f(verticesL12[0][0]/10f, (verticesL12[0][1]+0.5f)/10f);
                gl.glVertex3f(verticesL12[0][0], verticesL12[0][1]+0.5f, 13f);
                gl.glTexCoord2f((verticesL12[1][0]+0.5f)/10f, (verticesL12[1][1]+0.5f)/10f);
                gl.glVertex3f(verticesL12[1][0]+0.5f, verticesL12[1][1]+0.5f, 13f);
                gl.glTexCoord2f((verticesL12[2][0]+0.5f)/10f, (verticesL12[2][1]-0.5f)/10f);
                gl.glVertex3f(verticesL12[2][0]+0.5f, verticesL12[2][1]-0.5f, 13f);
                gl.glTexCoord2f(verticesL12[3][0]/10f, (verticesL12[3][1]-0.5f)/10f);
                gl.glVertex3f(verticesL12[3][0], verticesL12[3][1]-0.5f, 13f);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
                gl.glTexCoord3f(verticesL12[0][0]/10f, verticesL12[0][1]/10f, 12.5f/10f);
                gl.glVertex3f(verticesL12[0][0], verticesL12[0][1], 12.5f);
                gl.glTexCoord3f(verticesL12[0][0]/10f, (verticesL12[0][1]+0.5f)/10f, 13f/10f);
                gl.glVertex3f(verticesL12[0][0], verticesL12[0][1]+0.5f, 13f);
                gl.glTexCoord3f((verticesL12[1][0]+0.5f)/10f, (verticesL12[1][1]+0.5f)/10f, 13f/10f);
                gl.glVertex3f(verticesL12[1][0]+0.5f, verticesL12[1][1]+0.5f, 13f);
                gl.glTexCoord3f(verticesL12[1][0]/10f, verticesL12[1][1]/10f, 12.5f/10f);
                gl.glVertex3f(verticesL12[1][0], verticesL12[1][1], 12.5f);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
                gl.glTexCoord3f(verticesL12[1][0]/10f, verticesL12[1][1]/10f, 12.5f/10f);
                gl.glVertex3f(verticesL12[1][0], verticesL12[1][1], 12.5f);
                gl.glTexCoord3f((verticesL12[1][0]+0.5f)/10f, (verticesL12[1][1]+0.5f)/10f, 13f/10f);
                gl.glVertex3f(verticesL12[1][0]+0.5f, verticesL12[1][1]+0.5f, 13f);
                gl.glTexCoord3f((verticesL12[2][0]+0.5f)/10f, (verticesL12[2][1]-0.5f)/10f, 13f/10f);
                gl.glVertex3f(verticesL12[2][0]+0.5f, verticesL12[2][1]-0.5f, 13f);
                gl.glTexCoord3f(verticesL12[2][0]/10f, verticesL12[2][1]/10f, 12.5f/10f);
                gl.glVertex3f(verticesL12[2][0], verticesL12[2][1], 12.5f);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
                gl.glTexCoord3f(verticesL12[2][0]/10f, verticesL12[2][1]/10f, 12.5f/10f);
                gl.glVertex3f(verticesL12[2][0], verticesL12[2][1], 12.5f);
                gl.glTexCoord3f((verticesL12[2][0]+0.5f)/10f, (verticesL12[2][1]-0.5f)/10f, 13f/10f);
                gl.glVertex3f(verticesL12[2][0]+0.5f, verticesL12[2][1]-0.5f, 13f);
                gl.glTexCoord3f(verticesL12[3][0]/10f, (verticesL12[3][1]-0.5f)/10f, 13f/10f);
                gl.glVertex3f(verticesL12[3][0], verticesL12[3][1]-0.5f, 13f);
                gl.glTexCoord3f(verticesL12[3][0]/10f, verticesL12[3][1]/10f, 12.5f/10f);
                gl.glVertex3f(verticesL12[3][0], verticesL12[3][1], 12.5f);
            gl.glEnd();
            //Desenhar os detalhes de cima da parede
            gl.glBegin(GL2.GL_POLYGON);
                gl.glTexCoord3f((verticesL12[0][0]-0.5f)/10f, (verticesL12[0][1]+0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[0][0]-0.5f, verticesL12[0][1]+0.5f, 20f);
                gl.glTexCoord3f((verticesL12[1][0]+0.5f)/10f, (verticesL12[1][1]+0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[1][0]+0.5f, verticesL12[1][1]+0.5f, 20f);
                gl.glTexCoord3f((verticesL12[2][0]+0.5f)/10f, (verticesL12[2][1]-0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[2][0]+0.5f, verticesL12[2][1]-0.5f, 20f);
                gl.glTexCoord3f((verticesL12[3][0]-0.5f)/10f, (verticesL12[3][1]-0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[3][0]-0.5f, verticesL12[3][1]-0.5f, 20f);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
                gl.glTexCoord3f(verticesL12[0][0]/10f, verticesL12[0][1]/10f, 19.5f/10f);
                gl.glVertex3f(verticesL12[0][0], verticesL12[0][1], 19.5f);
                gl.glTexCoord3f((verticesL12[0][0]-0.5f)/10f, (verticesL12[0][1]+0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[0][0]-0.5f, verticesL12[0][1]+0.5f, 20f);
                gl.glTexCoord3f((verticesL12[1][0]+0.5f)/10f, (verticesL12[1][1]+0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[1][0]+0.5f, verticesL12[1][1]+0.5f, 20f);
                gl.glTexCoord3f(verticesL12[1][0]/10f, verticesL12[1][1]/10f, 19.5f/10f);
                gl.glVertex3f(verticesL12[1][0], verticesL12[1][1], 19.5f);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
                gl.glTexCoord3f(verticesL12[1][0]/10f, verticesL12[1][1]/10f, 19.5f/10f);
                gl.glVertex3f(verticesL12[1][0], verticesL12[1][1], 19.5f);
                gl.glTexCoord3f((verticesL12[1][0]+0.5f)/10f, (verticesL12[1][1]+0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[1][0]+0.5f, verticesL12[1][1]+0.5f, 20f);
                gl.glTexCoord3f((verticesL12[2][0]+0.5f)/10f, (verticesL12[2][1]-0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[2][0]+0.5f, verticesL12[2][1]-0.5f, 20f);
                gl.glTexCoord3f(verticesL12[2][0]/10f, verticesL12[2][1]/10f, 19.5f/10f);
                gl.glVertex3f(verticesL12[2][0], verticesL12[2][1], 19.5f);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
                gl.glTexCoord3f(verticesL12[2][0]/10f, verticesL12[2][1]/10f, 19.5f/10f);
                gl.glVertex3f(verticesL12[2][0], verticesL12[2][1], 19.5f);
                gl.glTexCoord3f((verticesL12[2][0]+0.5f)/10f, (verticesL12[2][1]-0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[2][0]+0.5f, verticesL12[2][1]-0.5f, 20f);
                gl.glTexCoord3f((verticesL12[3][0]-0.5f)/10f, (verticesL12[3][1]-0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[3][0]-0.5f, verticesL12[3][1]-0.5f, 20f);
                gl.glTexCoord3f(verticesL12[3][0]/10f, verticesL12[3][1]/10f, 19.5f/10f);
                gl.glVertex3f(verticesL12[3][0], verticesL12[3][1], 19.5f);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
                gl.glTexCoord3f(verticesL12[3][0]/10f, verticesL12[3][1]/10f, 19.5f/10f);
                gl.glVertex3f(verticesL12[3][0], verticesL12[3][1], 19.5f);
                gl.glTexCoord3f((verticesL12[3][0]-0.5f)/10f, (verticesL12[3][1]-0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[3][0]-0.5f, verticesL12[3][1]-0.5f, 20f);
                gl.glTexCoord3f((verticesL12[0][0]-0.5f)/10f, (verticesL12[0][1]+0.5f)/10f, 20f/10f);
                gl.glVertex3f(verticesL12[0][0]-0.5f, verticesL12[0][1]+0.5f, 20f);
                gl.glTexCoord3f(verticesL12[0][0]/10f, verticesL12[0][1]/10f, 19.5f/10f);
                gl.glVertex3f(verticesL12[0][0], verticesL12[0][1], 19.5f);
            gl.glEnd();
            //Desenhar as pirâmides
            for (int i=1; i<piramideL1.length-1; ) {
                float[] topo = piramideL1[0];
                float[] base1 = piramideL1[i++];
                float[] base2 = piramideL1[i];
                
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord3f(topo[0]/10f, topo[1]/10f, topo[2]/10f);
                    gl.glVertex3f(topo[0], topo[1], topo[2]);
                    gl.glTexCoord3f(base1[0]/10f, base1[1]/10f, base1[2]/10f);
                    gl.glVertex3f(base1[0], base1[1], base1[2]);
                    gl.glTexCoord3f(base2[0]/10f, base2[1]/10f, base2[2]/10f);
                    gl.glVertex3f(base2[0], base2[1], base2[2]);
                gl.glEnd();
            }
            for (int i=1; i<piramideL2.length-1; ) {
                float[] topo = piramideL2[0];
                float[] base1 = piramideL2[i++];
                float[] base2 = piramideL2[i];
                
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord3f(topo[0]/10f, topo[1]/10f, topo[2]/10f);
                    gl.glVertex3f(topo[0], topo[1], topo[2]);
                    gl.glTexCoord3f(base1[0]/10f, base1[1]/10f, base1[2]/10f);
                    gl.glVertex3f(base1[0], base1[1], base1[2]);
                    gl.glTexCoord3f(base2[0]/10f, base2[1]/10f, base2[2]/10f);
                    gl.glVertex3f(base2[0], base2[1], base2[2]);
                gl.glEnd();
            }
            for (int i=1; i<piramideL3.length-1; ) {
                float[] topo = piramideL3[0];
                float[] base1 = piramideL3[i++];
                float[] base2 = piramideL3[i];
                
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord3f(topo[0]/10f, topo[1]/10f, topo[2]/10f);
                    gl.glVertex3f(topo[0], topo[1], topo[2]);
                    gl.glTexCoord3f(base1[0]/10f, base1[1]/10f, base1[2]/10f);
                    gl.glVertex3f(base1[0], base1[1], base1[2]);
                    gl.glTexCoord3f(base2[0]/10f, base2[1]/10f, base2[2]/10f);
                    gl.glVertex3f(base2[0], base2[1], base2[2]);
                gl.glEnd();
            }
            for (int i=1; i<piramideL4.length-1; ) {
                float[] topo = piramideL4[0];
                float[] base1 = piramideL4[i++];
                float[] base2 = piramideL4[i];
                
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord3f(topo[0]/10f, topo[1]/10f, topo[2]/10f);
                    gl.glVertex3f(topo[0], topo[1], topo[2]);
                    gl.glTexCoord3f(base1[0]/10f, base1[1]/10f, base1[2]/10f);
                    gl.glVertex3f(base1[0], base1[1], base1[2]);
                    gl.glTexCoord3f(base2[0]/10f, base2[1]/10f, base2[2]/10f);
                    gl.glVertex3f(base2[0], base2[1], base2[2]);
                gl.glEnd();
            }
            for (int i=1; i<piramideL5.length-1; ) {
                float[] topo = piramideL5[0];
                float[] base1 = piramideL5[i++];
                float[] base2 = piramideL5[i];
                
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord3f(topo[0]/10f, topo[1]/10f, topo[2]/10f);
                    gl.glVertex3f(topo[0], topo[1], topo[2]);
                    gl.glTexCoord3f(base1[0]/10f, base1[1]/10f, base1[2]/10f);
                    gl.glVertex3f(base1[0], base1[1], base1[2]);
                    gl.glTexCoord3f(base2[0]/10f, base2[1]/10f, base2[2]/10f);
                    gl.glVertex3f(base2[0], base2[1], base2[2]);
                gl.glEnd();
            }
        gl.glPopMatrix();
        
    }
    
}
