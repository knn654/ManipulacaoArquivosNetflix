package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import br.edu.fateczl.filaobj.Fila;
import br.edu.fateczl.lista.listaObj.Lista;
import model.Serie;

public class NetflixController implements INetflixController {

	public NetflixController() {
		super();
	}

	@Override
	public void filaMajorGenre() throws IOException, Exception {
		String path = "C:\\Temp";
		String arquivo = "netflixSeries.csv";
		File arq = new File(path, arquivo);
		Fila animation = new Fila();
		Serie s = new Serie();
		Object inicializar = null;
		animation.insert(inicializar);

		Fila comedy = new Fila();
		comedy.insert(inicializar);
		Fila docuseries = new Fila();
		docuseries.insert(inicializar);
		Fila drama = new Fila();
		drama.insert(inicializar);
		Fila fAnimation = new Fila();
		fAnimation.insert(inicializar);
		Fila fLanguage = new Fila();
		fLanguage.insert(inicializar);
		Fila marvel = new Fila();
		marvel.insert(inicializar);
		Fila reality = new Fila();
		reality.insert(inicializar);
		Fila talkshow = new Fila();
		talkshow.insert(inicializar);
		if (arq.exists() && arq.isFile()) {
			System.out.println("Arquivo detectado!");
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null) {

				String[] vetLinha = linha.split(";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				s.major_genre = vetLinha[0];
				s.title = vetLinha[1];
				s.subgenre = vetLinha[2];
				s.premiere_year = Integer.parseInt(vetLinha[4]);
				s.episodes = vetLinha[10];
				s.status = vetLinha[6];
				s.imdb_rating = Integer.parseInt(vetLinha[11]);
				linha = buffer.readLine();

				switch (vetLinha[0]) {
				case "Animation":
					animation.insert(s);
					break;
				case "Comedy":
					comedy.insert(s);
					break;

				case "Docu-Series":
					docuseries.insert(s);
					break;

				case "Drama":
					drama.insert(s);
					break;

				case "Family Animation":
					fAnimation.insert(s);
					break;

				case "Foreign Language":
					fLanguage.insert(s);
					break;

				case "Marvel":
					marvel.insert(s);
					break;

				case "Reality":
					reality.insert(s);
					break;

				case "Talk Show":
					talkshow.insert(s);
					break;
				}
			}
			animation.remove();
			talkshow.remove();
			montarObjetoLista(talkshow);
		}
	}

	@Override
	public void listaPremiereYear() {

	}

	private void montarObjetoLista(Fila fila) {
		String path = "C:\\Temp";
		File arq2 = new File(path, "serie.txt");
		File dir = new File(path);
		StringBuffer sBuffer = new StringBuffer();
		while (!fila.isEmpty()) {
			try {
				Serie s1 = (Serie) fila.remove();
				sBuffer.append(s1.major_genre + "," + s1.title + "," + s1.subgenre + "," + s1.premiere_year + "," + s1.status
						+ "," + s1.episodes + "," + s1.imdb_rating);
				System.out.println(sBuffer.toString());
				arq2.createNewFile();
				if (dir.exists() && dir.isDirectory()) {
					if (arq2.exists() && arq2.isFile()) {
						String conteudo = sBuffer.toString();
						FileWriter abreArq = new FileWriter(arq2, true);
						PrintWriter escreveArq = new PrintWriter(abreArq);
						escreveArq.write(conteudo);
						escreveArq.flush();
						escreveArq.close();
						abreArq.close();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private Object montarObjetoFila() {
		return null;
	}

}
