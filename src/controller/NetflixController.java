package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import br.edu.fateczl.lista.listaObj.Lista;
import model.Serie;

public class NetflixController implements INetflixController {
	
	public NetflixController() {
		super();
	}
	
	@Override
	public void filaMajorGenre() throws IOException, Exception {
		montarObjetoLista();
	}
	
	@Override
	public void listaPremiereYear() {

	}
	
	private Object montarObjetoLista() throws Exception {
		String path = "C:\\Temp";
		String arquivo = "netflixSeries.csv";
		File arq = new File(path, arquivo);
		if (arq.exists() && arq.isFile()) {
			System.out.println("Arquivo detectado!");
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null) {
				Lista animation = new Lista();
				Object inicializar = null;
				animation.addFirst(inicializar);
				Lista comedy = new Lista();
				comedy.addFirst(inicializar);
				Lista docuseries = new Lista();
				docuseries.addFirst(inicializar);
				Lista drama = new Lista();
				drama.addFirst(inicializar);
				Lista fAnimation = new Lista();
				fAnimation.addFirst(inicializar);
				Lista fLanguage = new Lista();
				fLanguage.addFirst(inicializar);
				Lista marvel = new Lista();
				marvel.addFirst(inicializar);
				Lista reality = new Lista();
				reality.addFirst(inicializar);
				Lista talkshow = new Lista();
				talkshow.addFirst(inicializar);
				Serie s = new Serie();

				String[] vetLinha = linha.split(";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				s.major_genre = vetLinha[0]; 
				s.title = vetLinha[1]; 
				s.subgenre = vetLinha[2]; 
				s.premiere_year = Integer.parseInt(vetLinha[4]);
				s.episodes = vetLinha[10];
				s.status = vetLinha[6];
				s.imdb_rating = Integer.parseInt(vetLinha[11]);
				linha = buffer.readLine();
					
				switch(vetLinha[0]) {
				case "Animation":
					animation.addLast(s);
					break;
				case "Comedy":
					comedy.addLast(s);
					break;
					
				case "Docu-Series":
					docuseries.addLast(s);
					break;
					
				case "Drama":
					drama.addLast(s);
					break;
					
				case "Family Animation":
					fAnimation.addLast(s);
					break;
					
				case "Foreign Language":
					fLanguage.addLast(s);
					break;
					
				case "Marvel":
					marvel.addLast(s);
					break;
					
				case "Reality":
					reality.addLast(s);
					break;
					
				case "Talk Show":
					talkshow.addLast(s);
					break;
				}
				
				System.out.println(animation);
			}
		}
		return arq;
	}
	
	private Object montarObjetoFila() {
		return null;
	}


}
