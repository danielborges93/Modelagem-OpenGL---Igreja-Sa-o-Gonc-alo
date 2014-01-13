/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


public class Vertices {
    
    public static final float vertices[] = {
    //Plataforma: (250, 0, 400)
    
    //Chão
      0,   0,    0, //0 (0, 0, 0)
    250,   0,    0, //1 (250, 0, 0)
    250,   0,  400, //2 (250, 0, 400)
      0,   0,  400, //3 (0, 0, 400)
    
    //Pontas de baixo das paredes
     40,   0,   40, //4 (40, 0, 40)
    210,   0,   40, //5 (210, 0, 40)
    210,   0,  360, //6 (210, 0, 360)
     40,   0,  360, //7 (40, 0, 360)
    
    //Pontas de cima das paredes
     40, 100,   40, //8 (40, 100, 40)
    210, 100,   40, //9 (210, 100, 40)
    210, 100,  360, //10 (210, 100, 360)
     40, 100,  360, //11 (40, 100, 360)
};
    
}
