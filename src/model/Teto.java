/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.ufal.cg.AutoDrawnableObject;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;

/**
 *
 * @author Daniel Borges | Jário José
 */
public class Teto extends AutoDrawnableObject {
    
    public Teto(GL2 gl) {
        super(gl);
    }

    @Override
    protected String getTextureExtension() {
        return "jpg";
    }

    @Override
    protected String getTextureImg() {
        return "Teto.jpg";
    }
    
    @Override
    public void selfDraw(GL2 gl) {
        
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
        gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
        
        texture.enable(gl);
        texture.bind(gl);
        
        gl.glColor3f(1, 1, 1);
        
        float[][] vertices = {
            {4.5f, -20.25f, 13f},
            {4.5f, 20.25f, 13f},
            {-2.5f, 20.25f, 15f},
            {-2.5f, -20.25f, 15f},
            
            {-2.5f, 20.25f, 15f},
            {-2.5f, -20.25f, 15f},
            {-9.5f, -20.25f, 13f},
            {-9.5f, 20.25f, 13f}
        };
        float[][] tex = {
            {1f, 1f},
            {0f, 1f},
            {0f, 0f},
            {1f, 0f},
            
            {0f, 1f},
            {1f, 1f},
            {1f, 0f},
            {0f, 0f}
        };
        
        gl.glBegin(GL2.GL_POLYGON);
        for (int i=0; i<4; i++) {
            gl.glTexCoord2f(vertices[i][1]/5f, vertices[i][0]/5f);
            gl.glVertex3f(vertices[i][0], vertices[i][1], vertices[i][2]);
        }
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        for (int i=4; i<vertices.length; i++) {
            gl.glTexCoord2f(vertices[i][1]/5f, vertices[i][0]/5f);
            gl.glVertex3f(vertices[i][0], vertices[i][1], vertices[i][2]);
        }
        gl.glEnd();
        
        /*
        GLUT glut = new GLUT();
        
        gl.glPushMatrix();
            glut.glutSolidCube(1);
        gl.glPopMatrix();
        */
    }

}
