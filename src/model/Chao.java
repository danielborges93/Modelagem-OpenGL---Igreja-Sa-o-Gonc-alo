/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.ufal.cg.AutoDrawnableObject;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.GL2;

/**
 *
 * @author Daniel Borges | Jário José
 */
public class Chao extends AutoDrawnableObject {

    private int startList = gl.glGenLists(5);
    private GLUT glut = new GLUT();

    public Chao(GL2 gl) {
        super(gl);

        gl.glNewList(startList, GL2.GL_COMPILE);

        gl.glColor3f(1, 0, 0);

        glut.glutSolidCube(1);

        gl.glEndList();

    }

    private void desenhaCubo(float size, GL2 gl) {
        float[][] n = {
            {-1.0f, 0.0f, 0.0f},
            {0.0f, 1.0f, 0.0f},
            {1.0f, 0.0f, 0.0f},
            {0.0f, -1.0f, 0.0f},
            {0.0f, 0.0f, 1.0f},
            {0.0f, 0.0f, -1.0f}
        };
        int[][] faces = {
            {0, 1, 2, 3},
            {3, 2, 6, 7},
            {7, 6, 5, 4},
            {4, 5, 1, 0},
            {5, 6, 2, 1},
            {7, 4, 0, 3}
        };
        float[][] v = new float[8][3];
        int i;

        v[0][0] = v[1][0] = v[2][0] = v[3][0] = -size / 2f;
        v[4][0] = v[5][0] = v[6][0] = v[7][0] = size / 2f;
        v[0][1] = v[1][1] = v[4][1] = v[5][1] = -size / 2f;
        v[2][1] = v[3][1] = v[6][1] = v[7][1] = size / 2f;
        v[0][2] = v[3][2] = v[4][2] = v[7][2] = -size / 2f;
        v[1][2] = v[2][2] = v[5][2] = v[6][2] = size / 2f;

        for (i = 5; i >= 0; i--) {
            gl.glBegin(GL2.GL_QUADS);
            gl.glNormal3fv(n[i], 0);
            gl.glTexCoord3f(v[faces[i][0]][0], v[faces[i][0]][1], v[faces[i][0]][2]);
            gl.glVertex3fv(v[faces[i][0]], 0);
            gl.glTexCoord3f(v[faces[i][1]][0], v[faces[i][1]][1], v[faces[i][1]][2]);
            gl.glVertex3fv(v[faces[i][1]], 0);
            gl.glTexCoord3f(v[faces[i][2]][0], v[faces[i][2]][1], v[faces[i][2]][2]);
            gl.glVertex3fv(v[faces[i][2]], 0);
            gl.glTexCoord3f(v[faces[i][3]][0], v[faces[i][3]][1], v[faces[i][3]][2]);
            gl.glVertex3fv(v[faces[i][3]], 0);
            gl.glEnd();
        }
    }

    @Override
    protected String getTextureExtension() {
        return "jpg";
//        return null;
    }

    @Override
    protected String getTextureImg() {
        return "Ground.jpg";
//        return null;
    }

    @Override
    public void selfDraw(GL2 gl) {

        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_R, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
        
        texture.enable(gl);
        texture.bind(gl);
        
        gl.glColor3f(1, 0, 0);
        
//        desenhaCubo(4, gl);

        float[][] chao = {
            {4.5f, 21.25f, 0.01f},
            {4.5f, -20.25f, 0.01f},
            {-9.5f, -20.25f, 0.01f},
            {-9.5f, 21.25f, 0.01f}
        };
        
        gl.glPushMatrix();
            gl.glTranslatef(0f, 0f, -0.25f);
            gl.glScalef(25, 50, 0.5f);
            glut.glutSolidCube(1);
            
        gl.glPopMatrix();

        gl.glColor3f(0.1f, 1f, 0.1f);
        
        gl.glPushMatrix();
        gl.glTranslatef(-2.5f, -15.24f, 0f);
        gl.glScalef(8f, 10f, 1f);
        glut.glutSolidCube(1);
        gl.glPopMatrix();
        
        gl.glColor3f(1, 1, 1);
        
        gl.glPushMatrix();
            gl.glBegin(GL2.GL_POLYGON);
            for(float[] v : chao) {
                gl.glTexCoord2f(v[0], v[1]);
                gl.glVertex3f(v[0], v[1], v[2]);
            }
            gl.glEnd();
        gl.glPopMatrix();

//        float[][] vertices = {
//            {0, 0, 0},
//            {25, 0, 0},
//            {25, 50, 0},
//            {0, 50, 0}
//        };
//        
//        gl.glColor3f(1, 0, 0);
//        
//        gl.glPushMatrix();
//        
//        gl.glBegin(GL2.GL_POLYGON);
//        for (int i=0; i<4; i++) {
//            gl.glVertex3f(vertices[i][0], vertices[i][1], vertices[i][2]);
//        }
//        gl.glEnd();
//        
//        gl.glBegin(GL2.GL_POLYGON);
//        for (int i=0; i<4; i++) {
//            gl.glVertex3f(vertices[i][0], vertices[i][1]+1, vertices[i][2]+1);
//        }
//        gl.glEnd();
//        
//        gl.glPopMatrix();
    }

}
