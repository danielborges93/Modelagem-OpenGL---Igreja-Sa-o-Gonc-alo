/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import br.ufal.cg.AutoDrawnableObject;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.GL2;


public class Paredes extends AutoDrawnableObject {
    
//    public int startList = gl.glGenLists(5);
    
    public Paredes(GL2 gl) {
        super(gl);
    }

    @Override
    protected String getTextureExtension() {
//        return null;
        return "jpg";
    }

    @Override
    protected String getTextureImg() {
//        return null;
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
        
        GLUT glut = new GLUT();
        
//      ------------------------------------------------------------------------
        
//      Parede da frente
//        gl.glPushMatrix();
//            gl.glScalef(15, 0.6f, 15);
//            gl.glTranslatef(-0.167f, 34.95f, 0.5f);
//            glut.glutSolidCube(1);
//        gl.glPopMatrix();
        
        float[][] verticesL1 = {
            {4.5f, 20.25f, 14},
            {-2.5f, 20.25f, 16},
            {-2.5f, 20.25f, 10},
            {-2.25f, 20.25f, 9.98f},
            {-2f, 20.25f, 9.9f},
            {-1.75f, 20.25f, 9.85f},
            {-1.5f, 20.25f, 9.7f},
            {-1.25f, 20.25f, 9.55f},
            {-1f, 20.25f, 9.3f},
            {-0.75f, 20.25f, 8.97f},
            {-0.5f, 20.25f, 8},
            {-0.5f, 20.25f, 0},
            {4.5f, 20.25f, 0}
        };
        float[][] verticesL2 = {
            {-9.5f, 20.25f, 14},
            {-2.5f, 20.25f, 16},
            {-2.5f, 20.25f, 10},
            {-2.75f, 20.25f, 9.98f},
            {-3f, 20.25f, 9.9f},
            {-3.25f, 20.25f, 9.85f},
            {-3.5f, 20.25f, 9.7f},
            {-3.75f, 20.25f, 9.55f},
            {-4f, 20.25f, 9.3f},
            {-4.25f, 20.25f, 8.97f},
            {-4.5f, 20.25f, 8},
            {-4.5f, 20.25f, 0},
            {-9.5f, 20.25f, 0}
        };
        float[][] verticesTopo = {
            verticesL1[0],
            verticesL1[1],
            verticesL2[0],
            {-9.5f, 20.25f, 13f}
        };
        float[][] verticesArco = {
            verticesL1[11],
            verticesL1[10],
            verticesL1[9],
            verticesL1[8],
            verticesL1[7],
            verticesL1[6],
            verticesL1[5],
            verticesL1[4],
            verticesL1[3],
            verticesL1[2],
            
            verticesL2[2],
            verticesL2[3],
            verticesL2[4],
            verticesL2[5],
            verticesL2[6],
            verticesL2[7],
            verticesL2[8],
            verticesL2[9],
            verticesL2[10],
            verticesL2[11]
        };
        
        //Desenhar o primeiro lado
        gl.glPushMatrix();
            //Parte de dentro
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL1.length-1; i++) {
                gl.glTexCoord2f(verticesL1[0][0]/10f, verticesL1[0][2]/10f);
                gl.glVertex3f(verticesL1[0][0], verticesL1[0][1], verticesL1[0][2]);
                gl.glTexCoord2f(verticesL1[i][0]/10f, verticesL1[i][2]/10f);
                gl.glVertex3f(verticesL1[i][0], verticesL1[i][1], verticesL1[i][2]);
                gl.glTexCoord2f(verticesL1[i+1][0]/10f, verticesL1[i+1][2]/10f);
                gl.glVertex3f(verticesL1[i+1][0], verticesL1[i+1][1], verticesL1[i+1][2]);
            }
            gl.glEnd();
            //Parte de fora
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL1.length-1; i++) {
                gl.glTexCoord2f(verticesL1[0][0]/10f, verticesL1[0][2]/10f);
                gl.glVertex3f(verticesL1[0][0], verticesL1[0][1]+1, verticesL1[0][2]);
                gl.glTexCoord2f(verticesL1[i][0]/10f, verticesL1[i][2]/10f);
                gl.glVertex3f(verticesL1[i][0], verticesL1[i][1]+1, verticesL1[i][2]);
                gl.glTexCoord2f(verticesL1[i+1][0]/10f, verticesL1[i+1][2]/10f);
                gl.glVertex3f(verticesL1[i+1][0], verticesL1[i+1][1]+1, verticesL1[i+1][2]);
            }
            gl.glEnd();
            //Junção das duas partes
            for (int i=0; i<verticesTopo.length-1; ) {
                float[] v1 = verticesTopo[i++];
                float[] v2 = verticesTopo[i];
                
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord2f(v1[0]/10f, v1[1]/10f);
                    gl.glVertex3f(v1[0], v1[1], v1[2]);
                    gl.glTexCoord2f(v1[0]/10f, (v1[1]+1)/10f);
                    gl.glVertex3f(v1[0], v1[1]+1, v1[2]);
                    gl.glTexCoord2f(v2[0]/10f, (v2[1]+1)/10f);
                    gl.glVertex3f(v2[0], v2[1]+1, v2[2]);
                    gl.glTexCoord2f(v2[0]/10f, v2[1]/10f);
                    gl.glVertex3f(v2[0], v2[1], v2[2]);
                gl.glEnd();
            }
        gl.glPopMatrix();
        
        //Desenhar o segundo lado
        gl.glPushMatrix();
            //Parte de dentro
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL2.length-1; i++) {
                gl.glTexCoord2f(verticesL2[0][0]/10f, verticesL2[0][2]/10f);
                gl.glVertex3f(verticesL2[0][0], verticesL2[0][1], verticesL2[0][2]);
                gl.glTexCoord2f(verticesL2[i][0]/10f, verticesL2[i][2]/10f);
                gl.glVertex3f(verticesL2[i][0], verticesL2[i][1], verticesL2[i][2]);
                gl.glTexCoord2f(verticesL2[i+1][0]/10f, verticesL2[i+1][2]/10f);
                gl.glVertex3f(verticesL2[i+1][0], verticesL2[i+1][1], verticesL2[i+1][2]);
            }
            gl.glEnd();
            //Parte de fora
            gl.glBegin(GL2.GL_POLYGON);
            for (int i=1; i<verticesL2.length-1; i++) {
                gl.glTexCoord2f(verticesL2[0][0]/10f, verticesL2[0][2]/10f);
                gl.glVertex3f(verticesL2[0][0], verticesL2[0][1]+1, verticesL2[0][2]);
                gl.glTexCoord2f(verticesL2[i][0]/10f, verticesL2[i][2]/10f);
                gl.glVertex3f(verticesL2[i][0], verticesL2[i][1]+1, verticesL2[i][2]);
                gl.glTexCoord2f(verticesL2[i+1][0]/10f, verticesL2[i+1][2]/10f);
                gl.glVertex3f(verticesL2[i+1][0], verticesL2[i+1][1]+1, verticesL2[i+1][2]);
            }
            gl.glEnd();
            //Junção das duas partes
            for (int i=0; i<verticesArco.length-1; i++) {
                float[] v1 = verticesArco[i];
                float[] v2 = verticesArco[i+1];
                
                
                gl.glBegin(GL2.GL_POLYGON);
                    gl.glTexCoord2f(v1[0]/10f, v1[2]/10f);
                    gl.glVertex3f(v1[0], v1[1], v1[2]);
                    gl.glTexCoord2f(v1[0]/10f, (v1[2]+1)/10f);
                    gl.glVertex3f(v1[0], v1[1]+1, v1[2]);
                    gl.glTexCoord2f(v1[0]/10f, (v1[2]+1)/10f);
                    gl.glVertex3f(v2[0], v2[1]+1, v2[2]);
                    gl.glTexCoord2f(v1[0]/10f, v1[2]/10f);
                    gl.glVertex3f(v2[0], v2[1], v2[2]);
                gl.glEnd();
            }
        gl.glPopMatrix();
        
//      ------------------------------------------------------------------------
        
//      Parede esquerda
//        gl.glPushMatrix();
//            gl.glScalef(0.6f, 42.5f, 15);
//            gl.glTranslatef(8f, 0, 0.5f);
//            glut.glutSolidCube(1);
//        gl.glPopMatrix();
        
        float[][] verticesL3 = { //Divisão de cima
            {4.5f, 20.25f, 13},
            {4.5f, 20.25f, 8},
            {4.5f, -20.25f, 8},
            {4.5f, -20.25f, 13}
        };
        float[][] verticesL4 = { //Divisão de baixo
            {4.5f, 20.25f, 5},
            {4.5f, 20.25f, 0},
            {4.5f, -20.25f, 0},
            {4.5f, -20.25f, 5}
        };
        float[][] verticesL5 = { //Divisão direita
            verticesL3[1],
            verticesL4[0],
            {4.5f, 10f, 5},
            {4.5f, 10f, 8}
        };
        float[][] verticesL6 = { //Divisão do meio
            {4.5f, 8f, 8},
            {4.5f, 8f, 5},
            {4.5f, -13f, 5},
            {4.5f, -13f, 8}
        };
        float[][] verticesL7 = { //Divisão esquerda
            {4.5f, -15f, 8},
            {4.5f, -15f, 5},
            verticesL4[3],
            verticesL3[2]
        };
        
        gl.glPushMatrix();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL3) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL4) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL5) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL6) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL7) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
        gl.glPopMatrix();
        
//      ------------------------------------------------------------------------
        
//      Parede direita
//        gl.glPushMatrix();
//            gl.glScalef(15, 0.6f, 15);
//            gl.glTranslatef(-0.167f, -35, 0.5f);
//            glut.glutSolidCube(1);
//        gl.glPopMatrix();
        
        float[][] verticesL8 = { //Divisão de cima
            {-9.5f, 21.25f, 13},
            {-9.5f, 21.25f, 8},
            {-9.5f, -20.25f, 8},
            {-9.5f, -20.25f, 13}
        };
        float[][] verticesL9 = { //Divisão de baixo
            {-9.5f, 21.25f, 5},
            {-9.5f, 21.25f, 0},
            {-9.5f, -20.25f, 0},
            {-9.5f, -20.25f, 5}
        };
        float[][] verticesL10 = { //Divisão direita
            verticesL8[1],
            verticesL9[0],
            {-9.5f, 10f, 5},
            {-9.5f, 10f, 8}
        };
        float[][] verticesL11 = { //Divisão do meio
            {-9.5f, 8f, 8},
            {-9.5f, 8f, 5},
            {-9.5f, -13f, 5},
            {-9.5f, -13f, 8}
        };
        float[][] verticesL12 = { //Divisão esquerda
            {-9.5f, -15f, 8},
            {-9.5f, -15f, 5},
            verticesL9[3],
            verticesL8[2]
        };
        
        gl.glPushMatrix();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL8) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL9) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL10) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL11) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL12) {
                gl.glTexCoord2f(vertice[1]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
        gl.glPopMatrix();
        
//      ------------------------------------------------------------------------
        
//      Parede de trás
//        gl.glPushMatrix();
//            gl.glScalef(0.6f, 42.5f, 15);
//            gl.glTranslatef(-16.2f, 0, 0.5f);
//            glut.glutSolidCube(1);
//        gl.glPopMatrix();
        
        float[][] verticesL13 = {
            {-2.5f, -20.25f, 15f},
            verticesL3[3],
            verticesL4[2],
            verticesL9[2],
            verticesL8[3]
        };
        
        gl.glPushMatrix();
            gl.glBegin(GL2.GL_POLYGON);
            for (float[] vertice : verticesL13) {
                gl.glTexCoord2f(vertice[0]/10f, vertice[2]/10f);
                gl.glVertex3f(vertice[0], vertice[1], vertice[2]);
            }
            gl.glEnd();
        gl.glPopMatrix();
        
//      ------------------------------------------------------------------------
        
//      Detalhes das paredes
        float[][] verticesL14 = { //Parede da frente
            {-9.5f, 21.25f},
            {4.5f, 21.25f},
            {4.5f, -20.25f},
            {-9.5f, -20.25f}
        };
        
        //Desenhar na parede da frente
        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord3f(verticesL14[0][0]/10f, verticesL14[0][1]/10f, 13f/10f);
            gl.glVertex3f(verticesL14[0][0], verticesL14[0][1], 13f);
            gl.glTexCoord3f((verticesL14[0][0]-0.5f)/10f, (verticesL14[0][1]+0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[0][0]-0.5f, verticesL14[0][1]+0.5f, 13f);
            gl.glTexCoord3f(verticesL14[1][0]/10f, (verticesL14[1][1]+0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[1][0], verticesL14[1][1]+0.5f, 13f);
            gl.glTexCoord3f(verticesL14[1][0]/10f, verticesL14[1][1]/10f, 13f/10f);
            gl.glVertex3f(verticesL14[1][0], verticesL14[1][1], 13f);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord3f(verticesL14[0][0]/10f, verticesL14[0][1]/10f, 12.5f/10f);
            gl.glVertex3f(verticesL14[0][0], verticesL14[0][1], 12.5f);
            gl.glTexCoord3f((verticesL14[0][0]-0.5f)/10f, (verticesL14[0][1]+0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[0][0]-0.5f, verticesL14[0][1]+0.5f, 13f);
            gl.glTexCoord3f(verticesL14[1][0]/10f, (verticesL14[1][1]+0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[1][0], verticesL14[1][1]+0.5f, 13f);
            gl.glTexCoord3f(verticesL14[1][0]/10f, verticesL14[1][1]/10f, 12.5f/10f);
            gl.glVertex3f(verticesL14[1][0], verticesL14[1][1], 12.5f);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord3f(verticesL14[1][0]/10f, verticesL14[1][1]/10f, 13f/10f);
            gl.glVertex3f(verticesL14[1][0], verticesL14[1][1], 13f);
            gl.glTexCoord3f((verticesL14[1][0]+0.5f)/10f, verticesL14[1][1]/10f, 13f/10f);
            gl.glVertex3f(verticesL14[1][0]+0.5f, verticesL14[1][1], 13f);
            gl.glTexCoord3f((verticesL14[2][0]+0.5f)/10f, (verticesL14[2][1]-0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[2][0]+0.5f, verticesL14[2][1]-0.5f, 13f);
            gl.glTexCoord3f(verticesL14[2][0]/10f, verticesL14[2][1]/10f, 13f/10f);
            gl.glVertex3f(verticesL14[2][0], verticesL14[2][1], 13f);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord3f(verticesL14[1][0]/10f, verticesL14[1][1]/10f, 12.5f/10f);
            gl.glVertex3f(verticesL14[1][0], verticesL14[1][1], 12.5f);
            gl.glTexCoord3f((verticesL14[1][0]+0.5f)/10f, verticesL14[1][1]/10f, 13f/10f);
            gl.glVertex3f(verticesL14[1][0]+0.5f, verticesL14[1][1], 13f);
            gl.glTexCoord3f((verticesL14[2][0]+0.5f)/10f, (verticesL14[2][1]-0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[2][0]+0.5f, verticesL14[2][1]-0.5f, 13f);
            gl.glTexCoord3f(verticesL14[2][0]/10f, verticesL14[2][1]/10f, 12.5f/10f);
            gl.glVertex3f(verticesL14[2][0], verticesL14[2][1], 12.5f);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord3f(verticesL14[2][0]/10f, verticesL14[2][1]/10f, 13f/10f);
            gl.glVertex3f(verticesL14[2][0], verticesL14[2][1], 13f);
            gl.glTexCoord3f((verticesL14[2][0]+0.5f)/10f, (verticesL14[2][1]-0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[2][0]+0.5f, verticesL14[2][1]-0.5f, 13f);
            gl.glTexCoord3f((verticesL14[3][0]-0.5f)/10f, (verticesL14[3][1]-0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[3][0]-0.5f, verticesL14[3][1]-0.5f, 13f);
            gl.glTexCoord3f(verticesL14[3][0]/10f, verticesL14[3][1]/10f, 13f/10f);
            gl.glVertex3f(verticesL14[3][0], verticesL14[3][1], 13f);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord3f(verticesL14[2][0]/10f, verticesL14[2][1]/10f, 12.5f/10f);
            gl.glVertex3f(verticesL14[2][0], verticesL14[2][1], 12.5f);
            gl.glTexCoord3f((verticesL14[2][0]+0.5f)/10f, (verticesL14[2][1]-0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[2][0]+0.5f, verticesL14[2][1]-0.5f, 13f);
            gl.glTexCoord3f((verticesL14[3][0]-0.5f)/10f, (verticesL14[3][1]-0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[3][0]-0.5f, verticesL14[3][1]-0.5f, 13f);
            gl.glTexCoord3f(verticesL14[3][0]/10f, verticesL14[3][1]/10f, 12.5f/10f);
            gl.glVertex3f(verticesL14[3][0], verticesL14[3][1], 12.5f);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord3f(verticesL14[3][0]/10f, verticesL14[3][1]/10f, 13f/10f);
            gl.glVertex3f(verticesL14[3][0], verticesL14[3][1], 13f);
            gl.glTexCoord3f((verticesL14[3][0]-0.5f)/10f, (verticesL14[3][1]-0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[3][0]-0.5f, verticesL14[3][1]-0.5f, 13f);
            gl.glTexCoord3f((verticesL14[0][0]-0.5f)/10f, (verticesL14[0][1]+0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[0][0]-0.5f, verticesL14[0][1]+0.5f, 13f);
            gl.glTexCoord3f(verticesL14[0][0]/10f, verticesL14[0][1]/10f, 13f/10f);
            gl.glVertex3f(verticesL14[0][0], verticesL14[0][1], 13f);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord3f(verticesL14[3][0]/10f, verticesL14[3][1]/10f, 12.5f/10f);
            gl.glVertex3f(verticesL14[3][0], verticesL14[3][1], 12.5f);
            gl.glTexCoord3f((verticesL14[3][0]-0.5f)/10f, (verticesL14[3][1]-0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[3][0]-0.5f, verticesL14[3][1]-0.5f, 13f);
            gl.glTexCoord3f((verticesL14[0][0]-0.5f)/10f, (verticesL14[0][1]+0.5f)/10f, 13f/10f);
            gl.glVertex3f(verticesL14[0][0]-0.5f, verticesL14[0][1]+0.5f, 13f);
            gl.glTexCoord3f(verticesL14[0][0]/10f, verticesL14[0][1]/10f, 12.5f/10f);
            gl.glVertex3f(verticesL14[0][0], verticesL14[0][1], 12.5f);
        gl.glEnd();
        
//      ------------------------------------------------------------------------
        
    }
    
}
