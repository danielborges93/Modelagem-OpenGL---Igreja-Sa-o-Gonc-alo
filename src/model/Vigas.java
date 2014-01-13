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
public class Vigas extends AutoDrawnableObject {
    
    private final GLUT glut = new GLUT();

    public Vigas(GL2 gl) {
        super(gl);
    }
    
    private void desenhaCubo1(GL2 gl) {
        float[][] verticesL1 = {
            {0f, 0f, 0f},
            {0f, 0f, -1f},
            {-1f, 0f, -1f},
            {-1f, 0f, 0f}
        };
        float[][] verticesL2 = {
            {},
            {},
            {},
            {}
        };
    }
    
    private void desenhaVigas(GL2 gl) {
        
        gl.glPushMatrix();
            gl.glTranslatef(0f, 0f, 13f);
        
            gl.glPushMatrix();
                gl.glTranslatef(-2.5f, 0f, 0f);
                gl.glScalef(13.98f, 0.5f, -0.5f);
                gl.glTranslatef(0f, 0f, 0.5f);
                glut.glutSolidCube(1);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
                gl.glTranslatef(4.5f, 0f, 0f);
                gl.glRotatef(15, 0f, 1f, 0f);
                gl.glScalef(7.280109889280518f, 0.5f, 0.5f);
                gl.glTranslatef(-0.5f, 0f, -0.5f);
                glut.glutSolidCube(1);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
                gl.glTranslatef(-9.5f, 0f, 0f);
                gl.glRotatef(-15, 0f, 1f, 0f);
                gl.glScalef(7.280109889280518f, 0.5f, 0.5f);
                gl.glTranslatef(0.5f, 0f, -0.5f);
                glut.glutSolidCube(1);
            gl.glPopMatrix();
            
            gl.glPushMatrix();
                gl.glTranslatef(-2.5f, 0f, 0f);
                gl.glScalef(0.5f, 0.5f, 1.75f);
                gl.glTranslatef(0f, 0f, 0.5f);
                glut.glutSolidCube(1);
            gl.glPopMatrix();
            
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
        
        gl.glColor3f(0, 0, 0);
        
        gl.glPushMatrix();
            gl.glTranslatef(0f, 20f, 0f);
            for(int i=0; i<5; i++) {
                desenhaVigas(gl);
                if (i!=3)
                    gl.glTranslatef(0f, -10f, 0f);
                else
                    gl.glTranslatef(0f, -9.9f, 0f);
            }
        gl.glPopMatrix();
        
    }
    
}
