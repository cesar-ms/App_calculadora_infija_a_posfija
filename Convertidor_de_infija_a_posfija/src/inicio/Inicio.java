package inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import estructura.pila.Pila;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.TextField;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField textExpresion;
	private JTextField resultado;
	private JButton btnGenerar;
	private JButton btnAceptar;
	private JButton btnSalir;
	private JTextField textiInfija;
	private JTextField textResPost;

	/**
	 * iniciar la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el marco.
	 */
	public Inicio() {
		setBackground(new Color(255, 255, 255));// le damos color a la ventana.
		setForeground(new Color(0, 0, 0));// le damos color a las letras del nombre de la aplicacion.
		/**
		 * creamos la ventana.
		 */
		setTitle("INFIJA A POSFIJA");// le asignamos titulo o nombre a la aplicacion
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);// tamaño de la ventana
		contentPane = new JPanel();// se crea el panel de control
		contentPane.setBackground(new Color(0, 0, 128));// le damos color al panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// Se crea un borde vacío con las inserciones de 5 pixel.
		setContentPane(contentPane);// se aplican las propiedades al penel
		contentPane.setLayout(null);// Eliminamos el layout para colocar para las propiedades ne nuestros botones.
		setLocationRelativeTo(null);// metodo para centrar la ventana
		this.setResizable(false);// metodo para desabilitar la maximizacion de la ventana.

		/**
		 * se crea una etiqueta para señalar la parte de la interfaz que se ocupa para
		 * la evalucuion de posfija
		 */

		JLabel lblEvaluacionDePosfija = new JLabel(" EVALUACION DE POSFIJA ");
		lblEvaluacionDePosfija.setForeground(new Color(255, 255, 255));
		lblEvaluacionDePosfija.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblEvaluacionDePosfija.setBounds(139, 117, 186, 14);
		contentPane.add(lblEvaluacionDePosfija);

		/**
		 * Se crea una etiqueta para se señalar el lugar donde se va ingresar la
		 * exprecion posfija.
		 * 
		 */

		JLabel lblIngresar = new JLabel("INGRESAR ");
		lblIngresar.setForeground(new Color(240, 255, 255));
		lblIngresar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblIngresar.setBounds(20, 149, 76, 14);
		contentPane.add(lblIngresar);

		/**
		 * Se crea un campo de texto para ingresar la forma posfija de una exprecion.
		 * 
		 */
		textExpresion = new JTextField();
		textExpresion.setFont(new Font("Verdana", Font.BOLD, 13));
		textExpresion.setBounds(110, 143, 186, 27);
		contentPane.add(textExpresion);
		textExpresion.setColumns(10);
		/**
		 * Se crea una etiqueta para se señalar el lugar donde se va a mostrar el
		 * resulado de la exprecion .
		 * 
		 */
		JLabel lblResultado = new JLabel("RESULTADO");
		lblResultado.setForeground(new Color(240, 255, 255));
		lblResultado.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblResultado.setBounds(20, 180, 186, 27);
		contentPane.add(lblResultado);
		/**
		 * Se crea un campo de texto donde se mostrara la el resultado de la exprecion.
		 * 
		 */

		resultado = new JTextField();
		resultado.setForeground(new Color(0, 0, 0));
		resultado.setFont(new Font("Verdana", Font.BOLD, 13));
		resultado.setEditable(false);
		resultado.setBounds(110, 180, 187, 27);
		contentPane.add(resultado);
		resultado.setColumns(10);

		/**
		 * se crea el boton Aceptar. Este boton sirve para que cuando se accione o le
		 * demos un click, los argumentos que le pasamos a dichos metodos evaluen la
		 * exprecion y la resuelban.
		 * 
		 * 
		 */
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena = textExpresion.getText();// variable de tipo String que capta la exprecion que
														// escribimos.
				if (cadena.length() > 0) { //Nos aseguramos que la cadena contenga caracteres

					String[] arg = cadena.split(" ");// creamos una una cadena de caracteres de tipo String con el
														// nombre

					// arg.
					OperacionPostfija(arg);// llamamos al metodo para operacion posfija y le pasamos como argumento
					// arg(cadena) para que pueda evaluar.
				} else {
					JOptionPane.showMessageDialog(null, "Debes ingresar una expresion posfija para evaluar");
				}

			}
		});
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnAceptar.setBounds(315, 142, 99, 23);// btnGenerar.setBounds(290, 36, 99, 23);
		contentPane.add(btnAceptar);

		/**
		 * se crea una etiqueta para señalar la parte de la interfaz que se ocupa para
		 * la conversion
		 */

		JLabel Titulo = new JLabel("CONVERTIDOR DE INFIJA A POSFIJA");
		Titulo.setForeground(new Color(255, 255, 255));
		Titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		Titulo.setBounds(108, 11, 257, 14);
		contentPane.add(Titulo);

		/**
		 * Se crea una etiqueta para se señalar el lugar donde se va ingresar la
		 * exprecion infija.
		 * 
		 */
		JLabel lblInfija = new JLabel("INFIJA");
		lblInfija.setForeground(new Color(240, 255, 255));
		lblInfija.setBackground(new Color(248, 248, 255));
		lblInfija.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblInfija.setBounds(20, 39, 57, 14);
		contentPane.add(lblInfija);
		/**
		 * Se crea un campo de texto para ingresar la forma infija de una exprecion.
		 * 
		 */
		textiInfija = new JTextField();
		textiInfija.setFont(new Font("Verdana", Font.BOLD, 13));
		textiInfija.setBounds(110, 36, 186, 27);
		contentPane.add(textiInfija);
		textiInfija.setColumns(10);
		/**
		 * Se crea una etiqueta para se señalar el lugar donde se va a mostrar la
		 * exprecion infija a posfija.
		 * 
		 */
		JLabel lblPosfija = new JLabel("POSFIJA");
		lblPosfija.setForeground(new Color(240, 255, 255));
		lblPosfija.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblPosfija.setBounds(20, 78, 66, 14);
		contentPane.add(lblPosfija);
		/**
		 * Se crea un campo de texto donde se mostrara la exprecion de infija a posfija
		 * ya covertida.
		 * 
		 */
		textResPost = new JTextField();
		textResPost.setFont(new Font("Verdana", Font.BOLD, 13));
		textResPost.setEditable(false);
		textResPost.setBounds(110, 74, 186, 27);
		contentPane.add(textResPost);
		textResPost.setColumns(10);

		/**
		 * se crea el boton generar. Este boton sirve para que cuando se accione o le
		 * demos un click, los argumentos que le pasamos a dichos metodos evaluen la
		 * exprecion y la convietan a posfija.
		 * 
		 * 
		 */
		JButton btnGenerar = new JButton("GENERAR");
		btnGenerar.setForeground(new Color(0, 0, 0));
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String infija = textiInfija.getText();// variable de tipo String que capta la exprecion que escribimos.
				String[] arg = infija.split("");// creamos una una cadena de caracteres de tipo String con el nombre arg
				convertirApostfija(arg);// llamamos al metodo para convertir a posfija el argumento que le
										// pasamos(cadena).
			}
		});
		btnGenerar.setBackground(Color.LIGHT_GRAY);
		btnGenerar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnGenerar.setBounds(315, 36, 99, 23);
		contentPane.add(btnGenerar);

		/**
		 * se crea el boton salir para finalizar la aplicaion.
		 */

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBackground(Color.LIGHT_GRAY);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnSalir.setBounds(185, 237, 89, 23);
		contentPane.add(btnSalir);

		JLabel nota = new JLabel("Nota Importante: No utilice espacios en el convertidor.");
		nota.setForeground(new Color(255, 0, 0));
		nota.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		nota.setBounds(20, 280, 400, 50);
		contentPane.add(nota);

		JLabel nota2 = new JLabel("Simbolos Soportados: +, -, *, /,(),^");
		nota2.setForeground(new Color(255, 0, 0));
		nota2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		nota2.setBounds(20, 300, 400, 50);
		contentPane.add(nota2);
	}

	/**
	 * En este metodo se evalua la cadena posfija, en pocas palabras recorre la cadena hasta el ultimo elemento,
	 * y en ese ciclo va comparando cada caracter para verificar si es un operador o no para realizar la operacion correspondiente, 
	 * los operandos se van guardando en pila para que despues se utilicen en la operacion. 
	 * 
	 * Recibe como argumento la cadena a evaluar.
	 * 
	 * @param cadena
	 */
	private void OperacionPostfija(String[] cadena) {
		Pila<Double> pila = new Pila<>();// se crea una pila de tipo float 
		double valor = 0.0f;// se crea la variable valor de tipo float

		try {
			for (int i = 0; i < cadena.length; i++) {// se recorre la operacion posfija para hacer la evaluacion. se
				// detendra cuando haya recorrido cada uno.
				String simbolo = cadena[i]; //// se crea una variable simbolo de tipo string que capta cada elemneto
											//// que
				//// recore el for.
				if (!simbolo.equals("+") && // simbolo se comprara para saber si es diferente con cada operador.
						!simbolo.equals("-") && !simbolo.equals("*") && !simbolo.equals("/") && !simbolo.equals("^")) {
					pila.insertar(Double.parseDouble(simbolo));// se incerta simblolo si se cumple con la condicion
				} else {
					double oper2 = pila.sacar();// se saca el operador 1
					double oper1 = pila.sacar();// se saca el operador 2
					if (simbolo.equals("+")) {// El simbolo se compara con el operador mas y si se cumple los dos
						// operadorandos se suman.
						valor = oper1 + oper2;
					} else if (simbolo.equals("-")) {// El simbolo se compara con el operador menos y si se cumple
														// los
														// dos
						// operandos se restan.
						valor = oper1 - oper2;
					} else if (simbolo.equals("*")) {// El simbolo se compara con el operador por y si se cumple los
														// dos
						// operandos se multiplican.
						valor = oper1 * oper2;
					} else if (simbolo.equals("/")) {// El simbolo se compara con el operador divicion y si se
														// cumple
														// los
						// dos operando se dividen.
						if (oper2 != 0) {
							valor = oper1 / oper2;
						} else {
							JOptionPane.showMessageDialog(null, "No se puede dividir entre cero");
						}
					} else if (simbolo.equals("^")) {
						valor = Math.pow(oper1, oper2);
					}
					pila.insertar(valor);
				}
			}
			resultado.setText(String.valueOf(pila.sacar()));// mostramos el resultado en el apartado del campo de
															// texto que corresponde de la interfaz
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Algo salio mal, revisa tu expresión posfija");
		}

	}

	/**
	 * Este metodo utiliza una pila para guardar los operadoraes(*,-,+,/,^,(),), funciona de la siguiente manera,
	 * recorre la cadena y verifica si el caracter es un numero u operador, en dado caso que sea un numero este lo concatenara a la 
	 * cadena posfija, si no es asi, verificara la prioridad que tiene el operador y de esta manera lo va a insetar en pila, 
	 * cuando se requiera sacar el operador se concatenara en la cadena. Estos a grandes ragos.
	 * 
	 * Esta es una segunda version del metodo, anteriormente imprimia la cadena si espacios, esta version imprime y reconoce
	 * los numeros que van separados. Por ejemplo,
	 * 
	 * En la siguiente cadena 12+3, 
	 * 
	 * en la primera version imprimia la cadena posfija 123+
	 * 
	 * en esta version imprime 12 3 +, 
	 * 
	 * separando los numeros con los operadores para una mejor legibilidad.
	 * 
	 * 
	 * 
	 * 
	 * se le ingresa la operacion infija como argumento
	 * 
	 * @param infija
	 */
	public void convertirApostfija(String[] infija) {
		String postfija = "";
		int cont = 1;
		String temp = "";
		Pila<String> pila = new Pila<>();// se crea una nueva pila.

		for (int i = 0; i < infija.length; i++) {// se recorre la operacion infija para hacer la conversion. se detendra
													// cuando haya recorrido cada uno.
			String letra = infija[i]; // capta cada elemento de la operacion infija.
			if (esOperador(letra)) {// se hace la llamada al metodo para evaluar que el elemnto se un operador.
				if (letra.equals(")")) {// se hace la compracion con el parentisis de cierre

					while (!pila.verArriba().replace(" ", "").equals("("))// Mientras que el que esta arriba sea diferente de el signo el
															// parentesis de cierre "("
						temp = pila.sacar();
					    temp = temp.replace(" ", "");
					    postfija += temp + " ";
					
					if (pila.verArriba().replace(" ", "").equals("("))// si elque esta arriba es igual al parentesis abierto
						pila.sacar();// sacamos de la pila a ese elemento.
					cont++;

				}
				// termina el bloque del segundo if.
				if (pila.vacia()) {// si la pila esta vacia
					if (!letra.equals(")"))// si esdiferento de al parentesis cerado.
						if (letra.equals("(")) {
							pila.insertar(letra);// se inserta en la pila
						} else {
							pila.insertar(" " + letra);// se inserta en la pila
						}
					cont++;
				}
				// termina el bloque del cuarto if
				else {// si no se cumple lo anterior
					if (!letra.equals(")")) {// si la letra es diferente al parentesis de cierre.
						int pe = prioridadExp(letra);// se la llamada a el metodo de prioridad de la exprecion y el
														// numero de retorno sera el numero que se guarde en la variable
														// pe
						int pp = prioridadPila((String) pila.verArriba());// se la llamada a el metodo de prioridad de
																			// la pila y el numero de retorno sera el
																			// numero que se guarde en la variable pp

						if (pe > pp) {// se evalua la prioridad
							pila.insertar(" " +letra);// se inserta en la pila
							cont++;
						} // y la letra se inserta en pila
						else {// si no
							temp = pila.sacar();
							temp = temp.replace(" ", "");
							postfija += temp + " ";// se guarda y se concatena en la variable postfija
							pila.insertar(" " + letra);// se inserta en pila
							cont++;
						} // fin del else

					} // fin de quinto if
				} // fin del segundo else
			} // fin del primer if
			else {
				if (cont == infija.length) {
					cont = 0;
					postfija += letra;
				} else {
					String simbolo = infija[cont];
					if (esOperador(simbolo)) {
						postfija += letra + " ";
					} else {
						postfija += letra; // se concatena el simbolo en postfija
					}
					cont++;
					// postfija += letra;
				}

			}
		}
		while (!pila.vacia()) {// mientras que la pila sea vacia
			postfija += pila.sacar();// se concatena los elementos que se sacan de la pila.
		}
		textResPost.setText(String.valueOf(postfija)); // se muestra en el apartado de la posfija en la interfaz
														// (resultado).
	}

	/**
	 * Se le asigna la prioridad a cada operador de la expresion.
	 * 
	 * Recibe como argumento un string que es la letra que se esta evaluando.
	 * 
	 * @param x Retorna la prioridad del operador
	 * 
	 * @return
	 */
	public static int prioridadExp(String x) {
		x = x.replace(" ", "");
		if (x.equals("^"))
			return 3;
		if (x.equals("*") || x.equals("/"))
			return 2;
		if (x.equals("+") || x.equals("-"))
			return 1;
		if (x.equals("("))
			return 4;
		if (x.equals(")"))
			return 4;
		return 0;
	}

	/**
	 * Se le asigna prioridad a cada operador de la pila.
	 * 
	 * Recibe como argumento un string que es la letra que se esta evaluando.
	 * 
	 * @param x Retorna la prioridad del operador
	 * @return
	 */
	public static int prioridadPila(String x) {
		x = x.replace(" ", "");
		if (x.equals("^"))
			return 3;
		if (x.equals("*") || x.equals("/"))
			return 2;
		if (x.equals("+") || x.equals("-"))
			return 1;
		if (x.equals("("))
			return 0;
		if (x.equals(")"))
			return 0;
		return 0;
	}

	/**
	 * se compara letra con cada uno de los operadores Recibe como argumento la
	 * letra que se necesita verificar si es o no operador.
	 * 
	 * @param letra Retorna el caso que que sea un true y un false cuando no se
	 *              cumpla.
	 * @return
	 */
	public static boolean esOperador(String letra) {
		if (letra.equals("*") || letra.equals("/") || letra.equals("+") || letra.equals("-") || letra.equals("^")
				|| letra.equals("(") || letra.equals(")")) {
			return true;
		} else
			return false;
	}
}
