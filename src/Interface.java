import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Interface extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel labelResultado;
	private JTextField txtValorIngresado;
	private JButton btnConvertir;
	private JButton btnLimpiar;
	private JButton btnSalir;
	private JComboBox<String> listaConversiones;
	private JComboBox<String> listaTipoConversion;
	private String [] conversiones = {"Elija el tipo de conversion...",Constant.CONV_MONE,Constant.CONV_TEMP};
	private String [] monedas = {Constant.CONV_COPUSD, Constant.CONV_USDCOP, Constant.CONV_COPEUR, Constant.CONV_EURCOP, Constant.CONV_COPGBP,
			Constant.CONV_GBPCOP, Constant.CONV_COPJPY, Constant.CONV_JPYCOP, Constant.CONV_COPKRW, Constant.CONV_KRWCOP};
	private String [] temperaturas = {Constant.CONV_CELKEL, Constant.CONV_KELCEL, Constant.CONV_CELFAR,
			Constant.CONV_FARCEL, Constant.CONV_KELFAR, Constant.CONV_FARKEL};
	
	public Interface() {

		this.setSize(500,500); //Establecer tamaño de la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Conversor");
		setLocationRelativeTo(null);//Establecer la ventana en el centro de la pantalla
		
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {

		crearPanel();
		colocarLabel();
		colocarBotones();
		colocarCajaTexto();
		colocarListaDesplegable();
		callbackBotones();
	
	}
	
	private void crearPanel() {
		Color colorPanel = new Color(213, 245, 227);
		panel = new JPanel();//Creación de Panel
		panel.setLayout(null);
		panel.setBackground(colorPanel);
		this.getContentPane().add(panel);	
	}
	
	private void colocarLabel() {
		Color colorGris = new Color(217,217,217);
		//Etiqueta Titulo
		JLabel labelTitulo = new JLabel("<html><div style='text-align:center;'>CONVERSOR DE DIVISAS Y TEMPERATURA</div></html>", SwingConstants.CENTER);//Centrar texto
		labelTitulo.setOpaque(false);
		labelTitulo.setBounds(50, 26, 400, 105);
		labelTitulo.setFont(new Font("Swis721 Cn BT",1,35));
		
		//Etiqueta Seleccione tipo de conversión
		JLabel labelSeleccion = new JLabel("<html><div style='text-align:center;'>Seleccione el tipo de conversión</div></html>", SwingConstants.CENTER);//Centrar texto
		labelSeleccion.setOpaque(false);
		labelSeleccion.setBounds(19, 144, 185, 18);
		labelSeleccion.setFont(new Font("Swis721 Cn BT",1,14));
		
		//Etiqueta Seleccione valores de conversión
		JLabel labelConversion = new JLabel("<html><div style='text-align:center;'>Seleccione los valores de conversión</div></html>", SwingConstants.CENTER);//Centrar texto
		labelConversion.setOpaque(false);
		labelConversion.setBounds(19, 179, 185, 36);
		labelConversion.setFont(new Font("Swis721 Cn BT",1,14));
		
		//Etiqueta Ingrese la cantidad a convertir
		JLabel labelCantidad = new JLabel("<html><div style='text-align:center;'>Ingrese la cantidad a convertir</div></html>", SwingConstants.CENTER);//Centrar texto
		labelCantidad.setOpaque(false);
		labelCantidad.setBounds(19, 233, 185, 18);
		labelCantidad.setFont(new Font("Swis721 Cn BT",1,14));
		
		labelResultado = new JLabel("<html><div style='text-align:center;'>  </div></html>", SwingConstants.CENTER);//Centrar texto
		labelResultado.setOpaque(true);
		labelResultado.setBackground(colorGris);
		labelResultado.setBounds(86, 360, 328, 87);
		labelResultado.setFont(new Font("arial",1,50));
		labelResultado.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		panel.add(labelTitulo);
		panel.add(labelSeleccion);
		panel.add(labelCantidad);
		panel.add(labelConversion);
		panel.add(labelResultado);		
	}

	private void colocarBotones() {
		Color colorBoton = new Color(217,217,217);
		
		//Botón Convertir
		btnConvertir = new JButton("CONVERTIR");
		btnConvertir.setBounds(23,291,127,49);
		btnConvertir.setFont(new Font("Swis721 Cn BT",1,18));
		btnConvertir.setBackground(colorBoton);
		btnConvertir.setBorder(new RoundedBorder(20));
		btnConvertir.setEnabled(false);
		panel.add(btnConvertir);
		
		//Botón Limpiar
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(179,291,127,49);
		btnLimpiar.setFont(new Font("Swis721 Cn BT",1,18));
		btnLimpiar.setBackground(colorBoton);
		btnLimpiar.setBorder(new RoundedBorder(20));
		panel.add(btnLimpiar);
			
		
		//Botón Salir
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(336,291,127,49);
		btnSalir.setFont(new Font("Swis721 Cn BT",1,18));
		btnSalir.setBackground(colorBoton);
		btnSalir.setBorder(new RoundedBorder(20));
		panel.add(btnSalir);
	}
	
	private void colocarCajaTexto() {
		Color cajaTexto = new Color(217,217,217);
		//Caja Texto Valor
		txtValorIngresado = new JTextField();
		txtValorIngresado.setBounds(220,232,245,21);
		txtValorIngresado.setBackground(cajaTexto);
		//valor.setBorder(new RoundedBorder(40));
		panel.add(txtValorIngresado);
		
		//Accion verificar caracteres
		KeyListener verificacionCaracteres = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				validacionCaracteres(e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {	
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		};
		txtValorIngresado.addKeyListener(verificacionCaracteres);
	}
	
	private void colocarListaDesplegable() {
		//Definir listas
		
		//Lista desplegable Conversiones
		listaConversiones = new JComboBox<>(conversiones);
		listaConversiones.setBounds(220, 143, 256, 21);
		panel.add(listaConversiones);
		
		listaTipoConversion = new JComboBox<>();
		listaTipoConversion.setBounds(220,187,256,21);
		panel.add(listaTipoConversion);

		
		ActionListener listConver = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listaConversiones.getSelectedItem().equals(Constant.CONV_MONE)) {
					listaTipoConversion.setSelectedItem(null);
					listaTipoConversion.removeAllItems();
					for(int i=0;i<monedas.length;i++) {
						listaTipoConversion.addItem(monedas[i]);
					}
				}else if(listaConversiones.getSelectedItem().equals(Constant.CONV_TEMP)) {
					listaTipoConversion.setSelectedItem(null);
					listaTipoConversion.removeAllItems();
					for(int i=0;i<temperaturas.length;i++) {
						listaTipoConversion.addItem(temperaturas[i]);
					}
				}
			}
		};
		listaConversiones.addActionListener(listConver);
		
		ActionListener listTipoConv = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnConvertir.setEnabled(true);
			}
		};
		listaTipoConversion.addActionListener(listTipoConv);
		
		
	}

	private void callbackBotones() {
		//Acción Botón Limpiar
		ActionListener bttLimpiar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				labelResultado.setText("");
				txtValorIngresado.setText("");
			}
		};
		btnLimpiar.addActionListener(bttLimpiar);
		
		//Acción Botón Convertir
		ActionListener aplicarConversion = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					validarCamposVacios();
					String conversion = listaTipoConversion.getSelectedItem().toString();
					double texto_valor = Double.parseDouble(txtValorIngresado.getText());
					Conversion conversion_valor = new Conversion(conversion,texto_valor);
					labelResultado.setText(Double.toString(conversion_valor.realizarConversion())+conversion_valor.generarSimbolo());
				}catch(NumberFormatException ex) {
					System.out.println("Excepcion atrapada");
				}
			}
		};
		btnConvertir.addActionListener(aplicarConversion);
		
		ActionListener btnsalir = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
			
		};
		btnSalir.addActionListener(btnsalir);


	}

	private void cerrar() {
		String [] botones = {"Si","No"};
		int eleccionSalir = JOptionPane.showOptionDialog(this, "¿Seguro que desea salir?", "Alerta Salir", 0, 0, null, botones, this);
		if(eleccionSalir==JOptionPane.YES_OPTION) { 
			System.exit(0);
		}else if(eleccionSalir==JOptionPane.NO_OPTION) {
			System.out.println("Hola");
		}
	}
	
	private void validacionCaracteres(java.awt.event.KeyEvent evento) {	
		if(evento.getKeyChar() >=32 && evento.getKeyChar()<=45
				|| evento.getKeyChar()>=58) {
			evento.consume();
			JOptionPane.showMessageDialog(this, "Solo se permite el uso de números en el campo de texto");
		}
		
		System.out.println(""+evento.getKeyChar());
		
	}
	
	private void validarCamposVacios() {
		if(txtValorIngresado.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No se puede convertir un campo vacío");
		}
	}
}
