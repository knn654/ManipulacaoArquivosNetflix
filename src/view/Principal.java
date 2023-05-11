package view;

import controller.NetflixController;

import java.io.IOException;

import controller.INetflixController;
import model.Serie;
public class Principal {
	
	public static void main(String[] args) throws IOException, Exception {
		NetflixController netflixController = new NetflixController();
		netflixController.filaMajorGenre();
	}

}
