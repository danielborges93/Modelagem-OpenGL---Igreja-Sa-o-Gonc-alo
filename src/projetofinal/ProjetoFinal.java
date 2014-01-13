/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetofinal;

import br.ufal.cg.AutoDrawnableObject;
import br.ufal.cg.CGTemplate;
import model.Banco;
import java.util.ArrayList;
import java.util.List;
import javax.media.opengl.*;
import model.Pulpito;
import model.Chao;
import model.Cruz;
import model.Janelas;
import model.Luzes;
import model.ParedeInterior;
import model.Paredes;
import model.Portas;
import model.Teto;
import model.Torre;
import model.Ventilador;
import model.Vigas;

/**
 *
 * @author Daniel Borges | Jário José
 */

public class ProjetoFinal extends CGTemplate {
    
    private static final int MODELO_LUZ = GL2.GL_AMBIENT_AND_DIFFUSE;
    private static final int FONTE_LUZ = 1;
    
    private static final long serialVersionUID = 1L;
    
    private final float[] ambientLightArray = { 1f, 1f, 1f, 1f };
    private final float[] diffuseLightArray = { 1f, 1f, 1f, 1f };

    private final float[] luzAmbiente = {0.2f, 0.2f, 0.2f, 1.0f}; 
    private final float[] luzDifusa = {0.7f, 0.7f, 0.7f, 1.0f};	   // "cor" 
    private final float[] luzEspecular = {1.0f, 1.0f, 1.0f, 1.0f};// "brilho" 
    private final float[] posicaoLuz = {0.0f, 50.0f, 50.0f, 1.0f};
    private final float[] especularidade = {1.0f, 1.0f, 1.0f, 1.0f};
    
    private Portas porta;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProjetoFinal projetoFinal = new ProjetoFinal();
        projetoFinal.moveCameraX_Y(250);
        projetoFinal.moveCameraY(250);
    }

    @Override
    protected List<AutoDrawnableObject> initObjects(GL2 gl) {
        
        List<AutoDrawnableObject> list = new ArrayList();
        
        list.add(new Chao(gl));
        list.add(new Paredes(gl));
        list.add(new Torre(gl));
        list.add(new Teto(gl));
        list.add(new Cruz(gl));
        list.add(new Janelas(gl));
        porta = new Portas(gl);
        list.add(porta);
        list.add(new ParedeInterior(gl));
        list.add(new Banco(gl));
        list.add(new Pulpito(gl));
        list.add(new Vigas(gl));
        list.add(new Luzes(gl));
        list.add(new Ventilador(gl));
        
        return list;
    }

    @Override
    protected String getApplicationName() {
        return "Capela São Gonçalo";
    }

    @Override
    protected void initLight(GL2 gl) {
        /*
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glEnable(GL2.GL_COLOR_MATERIAL);
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLightArray, 0);
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLightArray, 0);
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specularLightArray, 0);
        gl.glLightfv(GL2.GL_LIGHT0, MODELO_LUZ, diffuseLightArray, 0);
//        gl.glLightf(GL2.GL_LIGHT0, GL2.GL_AMBIENT, 0);
//        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, diffuseLightArray, 0);
        gl.glMateriali(GL2.GL_FRONT, GL2.GL_SHININESS, 10);
        */
//        /*
        
        gl.glEnable(GL2.GL_LIGHTING);
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLightArray, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLightArray, 0);
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT_AND_DIFFUSE, diffuseLightArray, 0);
//	gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specularLightArray, 0);
        gl.glEnable(GL2.GL_LIGHT0);
//	gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, specularLightArray, 0);
	gl.glMateriali(GL2.GL_FRONT, GL2.GL_SHININESS, 10);
        gl.glEnable(GL2.GL_COLOR_MATERIAL);
//        */
        /*
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, especularidade, 0);
        gl.glMateriali(GL2.GL_FRONT, GL2.GL_SHININESS, 60);
        gl.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT, luzAmbiente, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, luzAmbiente, 0); 
	gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, luzDifusa, 0);
	gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, luzEspecular, 0);
	gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, posicaoLuz, 0);
        
        gl.glEnable(GL2.GL_COLOR_MATERIAL);
	gl.glEnable(GL2.GL_LIGHTING);
	gl.glEnable(GL2.GL_LIGHT0);
	gl.glEnable(GL2.GL_DEPTH_TEST);
        */
    }

    @Override
    protected float[] lightPosition() {
//        return new float[] { 12.5f, 25, 20, FONTE_LUZ};
        return new float[] { -22, 0, 13, FONTE_LUZ};
//        return new float[] { 0, 0, 13, FONTE_LUZ};
//        return new float[] { 10, -10, 8, 1 };
    }

    @Override
    protected int getShadeModel() {
        return GL2.GL_SMOOTH;
    }

    @Override
    public void processKeyPressed(char c) {
        
        if (c == 27) {
            System.exit(0);
        }
        else if (c == 'o') {
            porta.abrir();
        }
        else if (c == 'f') {
            porta.fechar();
        }
        
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        
    }
    
}
