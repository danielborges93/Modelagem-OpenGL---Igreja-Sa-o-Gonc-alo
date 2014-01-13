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
public class ParedeInterior extends AutoDrawnableObject {

    public ParedeInterior(GL2 gl) {
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
        
//      Parte grudada na parede
//      Dimensões: 10x12.5
        float[][] verticesL1 = {
            {-7.5f, -19.25f, 0f},
            {-7.5f, -19.25f, 12.5f},
            {2.5f, -19.25f, 12.5f},
            {2.5f, -19.25f, 0f}
        };
        
        //Desenhar a parte gudada na parede
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL1) {
            gl.glTexCoord2f(v[0]/10f, v[2]/10f);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        //Grudar na parede
        for (int i=0; i<verticesL1.length-1; ) {
            float[] v1 = verticesL1[i++];
            float[] v2 = verticesL1[i];
            
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
        
//      Parte da frente
//      Dimensões: 6x11
//      Primeira parte da parte da frente
        float[][] verticesL2 = { //lado direito
            {-5.5f, -18.25f, 11f},
            {-5.5f, -18.25f, 6f},
            {-3.5f, -18.25f, 6f},
            {-3.5f, -18.25f, 9f},
            
            {-3.25f, -18.25f, 9.6f},
            {-3f, -18.25f, 9.86f},
            {-2.75f, -18.25f, 9.96f},
            
            {-2.5f, -18.25f, 10f},
            {-2.5f, -18.25f, 11f}
        };
//      Segunda parte da parte da frente
        float[][] verticesL3 = { //lado esquerdo
            {0.5f, -18.25f, 11f},
            {-2.5f, -18.25f, 11f},
            {-2.5f, -18.25f, 10f},
            
            {-2.25f, -18.25f, 9.96f},
            {-2f, -18.25f, 9.86f},
            {-1.75f, -18.25f, 9.6f},
            
            {-1.5f, -18.25f, 9f},
            {-1.5f, -18.25f, 6f},
            {0.5f, -18.25f, 6f}
        };
//      Parte de baixo da parte da frente
        float[][] verticesL4 = {
            {-5.5f, -18.25f, 0f},
            {-5.5f, -18.25f, 6f},
            {0.5f, -18.25f, 6f},
            {0.5f, -18.25f, 0f}
        };
//      Parte que se juntam
        float[][] verticesL5 = {
            //L2 de 2 a 7
            verticesL2[2],
            verticesL2[3],
            verticesL2[4],
            verticesL2[5],
            verticesL2[6],
            verticesL2[7],
            //L3 de 2 a 7
            verticesL3[2],
            verticesL3[3],
            verticesL3[4],
            verticesL3[5],
            verticesL3[6],
            verticesL3[7],
            
            verticesL3[7],
            verticesL2[2]
        };
        
        //Desenhar o lado direito da parte da frente
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
        //Desenhar o lado esquerdo da parte da frente
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
        //Junção das duas partes
        for (int i=0; i<verticesL5.length-1; ) {
            float[] v1 = verticesL5[i++];
            float[] v2 = verticesL5[i];

            gl.glBegin(GL2.GL_POLYGON);
                gl.glTexCoord2f(v1[1]/10f, v1[2]/10f);
                gl.glVertex3f(v1[0], v1[1], v1[2]);
                gl.glTexCoord2f((v1[1]-1f)/10f, v1[2]/10f);
                gl.glVertex3f(v1[0], v1[1]-1, v1[2]);
                gl.glTexCoord2f((v2[1]-1f)/10f, v2[2]/10f);
                gl.glVertex3f(v2[0], v2[1]-1, v2[2]);
                gl.glTexCoord2f(v2[1]/10f, v2[2]/10f);
                gl.glVertex3f(v2[0], v2[1], v2[2]);
            gl.glEnd();
        }
        //Desenhar a parte de baixo da parte da frente
        gl.glBegin(GL2.GL_POLYGON);
        for (float[] v : verticesL4) {
            gl.glTexCoord2f(v[0]/10f, v[2]/10f);
            gl.glVertex3f(v[0], v[1], v[2]);
        }
        gl.glEnd();
        //Juntar as partes
        
        //Grudar na parede
        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord2f(verticesL4[0][0]/10f, verticesL4[0][2]/10f);
            gl.glVertex3f(verticesL4[0][0], verticesL4[0][1], verticesL4[0][2]);
            gl.glTexCoord2f((verticesL4[0][0]-1)/10f, verticesL4[0][2]/10f);
            gl.glVertex3f(verticesL4[0][0]-1, verticesL4[0][1]-1, verticesL4[0][2]);
            gl.glTexCoord2f((verticesL2[0][0]-1)/10f, verticesL2[0][2]/10f);
            gl.glVertex3f(verticesL2[0][0]-1, verticesL2[0][1]-1, verticesL2[0][2]);
            gl.glTexCoord2f(verticesL2[0][0]/10f, verticesL2[0][2]/10f);
            gl.glVertex3f(verticesL2[0][0], verticesL2[0][1], verticesL2[0][2]);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord2f(verticesL2[0][0]/10f, verticesL2[0][2]/10f);
            gl.glVertex3f(verticesL2[0][0], verticesL2[0][1], verticesL2[0][2]);
            gl.glTexCoord2f((verticesL2[0][0]-1)/10f, verticesL2[0][2]/10f);
            gl.glVertex3f(verticesL2[0][0]-1, verticesL2[0][1]-1, verticesL2[0][2]);
            gl.glTexCoord2f((verticesL3[0][0]+1)/10f, verticesL3[0][2]/10f);
            gl.glVertex3f(verticesL3[0][0]+1, verticesL3[0][1]-1, verticesL3[0][2]);
            gl.glTexCoord2f(verticesL3[0][0]/10f, verticesL3[0][2]/10f);
            gl.glVertex3f(verticesL3[0][0], verticesL3[0][1], verticesL3[0][2]);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
            gl.glTexCoord2f(verticesL3[0][0]/10f, verticesL3[0][2]/10f);
            gl.glVertex3f(verticesL3[0][0], verticesL3[0][1], verticesL3[0][2]);
            gl.glTexCoord2f((verticesL3[0][0]+1)/10f, verticesL3[0][2]/10f);
            gl.glVertex3f(verticesL3[0][0]+1, verticesL3[0][1]-1, verticesL3[0][2]);
            gl.glTexCoord2f((verticesL4[3][0]+1)/10f, verticesL4[3][2]/10f);
            gl.glVertex3f(verticesL4[3][0]+1, verticesL4[3][1]-1, verticesL4[3][2]);
            gl.glTexCoord2f(verticesL4[3][0]/10f, verticesL4[3][2]/10f);
            gl.glVertex3f(verticesL4[3][0], verticesL4[3][1], verticesL4[3][2]);
        gl.glEnd();
        
    }
    
}
