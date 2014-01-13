package demo;

import javax.media.opengl.GL2;

import com.jogamp.opengl.util.gl2.GLUT;

import br.ufal.cg.AutoDrawnableObject;

public class Floor extends AutoDrawnableObject {

	private GLUT glut;
	private int startList = gl.glGenLists(5);

	public Floor(GL2 gl) {
		super(gl);
		glut = new GLUT();
		compileGround(gl);
	}

	private void compileGround(GL2 gl) {
		gl.glNewList(startList, GL2.GL_COMPILE);

		gl.glColor3f(0.0f, 0.0f, 0.0f);

		glut.glutSolidCube(0.15f);

		gl.glEndList();
	}

	@Override
	public void selfDraw(GL2 gl) {

		gl.glPushMatrix();

		gl.glTranslatef(8.6f, -15.0f, 0.0f);

		gl.glScalef(85.0f, 200.0f, 1.0f);

		gl.glCallList(startList);

		gl.glPopMatrix();

	}

	@Override
	protected String getTextureExtension() {
		return "jpg";
	}

	@Override
	protected String getTextureImg() {
		return "textures/Ground.jpg";
	}

}
