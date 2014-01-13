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
public class Luzes extends AutoDrawnableObject {

    private final GLUT glut = new GLUT();
    
    public Luzes(GL2 gl) {
        super(gl);
    }
    
    private void desenhaLuz(GL2 gl) {
        
        gl.glColor3f(0f, 0f, 0f);
        
        gl.glPushMatrix();
            gl.glTranslatef(0f, 0f, 9f);
            glut.glutSolidCylinder(0.01f, 4f, 10, 10);
        gl.glPopMatrix();
        
        gl.glColor3f(1, 1, 1);
        
        gl.glPushMatrix();
            gl.glTranslatef(0f, 0f, 9.2f);
            glut.glutSolidSphere(0.1f, 10, 10);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
            gl.glTranslatef(0f, 0f, 8.9f);
            glut.glutSolidCylinder(0.1f, 0.3f, 10, 10);
        gl.glPopMatrix();
        
    }

    @Override
    protected String getTextureExtension() {
        return null;
    }

    @Override
    protected String getTextureImg() {
        return null;
    }

    @Override
    public void selfDraw(GL2 gl) {
        
        gl.glPushMatrix();
            gl.glTranslatef(1.5f, 10f, 0f);
            
            for (int i=0; i<3; i++) {
                desenhaLuz(gl);
                gl.glTranslatef(0f, -10f, 0f);
            }
        gl.glPopMatrix();
        
        gl.glPushMatrix();
            gl.glTranslatef(-6f, 10f, 0f);
            
            for (int i=0; i<3; i++) {
                desenhaLuz(gl);
                gl.glTranslatef(0f, -10f, 0f);
            }
        gl.glPopMatrix();
        
    }
    
}
