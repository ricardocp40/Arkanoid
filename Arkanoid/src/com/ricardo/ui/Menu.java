package com.ricardo.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.ricardo.main.VarGlobais;

public class Menu {

	public String[] options = {"novo jogo","carregar jogo","sair"};
	
	public int currentOption = 0;
	public int maxOption = options.length - 1;
	
	public boolean up,down,enter;
	
	public boolean pause = false;
	
	
	public void tick() {
		if(up) {
			up = false;
			currentOption--;
			if(currentOption < 0)
				currentOption = maxOption;
		}
		if(down) {
			down = false;
			currentOption++;
			if(currentOption > maxOption)
				currentOption = 0;
		}
		if(enter) {
			enter = false;
			if(options[currentOption] == "novo jogo" || options[currentOption] == "continuar") {
				VarGlobais.setGameState("NORMAL");
				pause = false;
			}else if(options[currentOption] == "sair") {
				System.exit(1);
			}
		}
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//g2.setColor(new Color(0,0,0,100));
		//g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD,36));
		
		g.drawString(">Danki.Code<", (VarGlobais.getGameWidth() * VarGlobais.getGameEscala()) / 2 - 110, (VarGlobais.getGameHeight() * VarGlobais.getGameEscala()) / 2 - 160);
		
		//Opcoes de menu
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.BOLD,24));
		if(pause == false)
			g.drawString("Novo jogo", (VarGlobais.getGameWidth() * VarGlobais.getGameEscala()) / 2 - 50, 160);
		else
			g.drawString("Resumir", (VarGlobais.getGameWidth() * VarGlobais.getGameEscala()) / 2 - 40, 160);
		g.drawString("Carregar jogo", (VarGlobais.getGameWidth() * VarGlobais.getGameEscala()) / 2 - 70, 200);
		g.drawString("Sair", (VarGlobais.getGameWidth() * VarGlobais.getGameEscala()) / 2 - 10, 240);
		
		if(options[currentOption] == "novo jogo") {
			g.drawString(">", (VarGlobais.getGameWidth() * VarGlobais.getGameEscala()) / 2 - 90, 160);
		}else if(options[currentOption] == "carregar jogo") {
			g.drawString(">", (VarGlobais.getGameWidth() * VarGlobais.getGameEscala()) / 2 - 90, 200);
		}else if(options[currentOption] == "sair") {
			g.drawString(">", (VarGlobais.getGameWidth() * VarGlobais.getGameEscala()) / 2 - 40, 240);
		}
	}
	
}