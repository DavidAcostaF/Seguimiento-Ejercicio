package presentacion;

import dtos.EjercicioDiarioDTO;
import dtos.RutinaDTO;
import dtos.UsuarioDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import negocio.IRutinaBO;
import negocio.IUsuarioBO;
import negocio.RutinaBO;
import negocio.UsuariosBO;

/**
 *
 * @author af_da
 */
public class Menu extends javax.swing.JFrame implements Observador{
    
    private IRutinaBO rNegocio;
    private IUsuarioBO uNegocio;
    private DefaultTableModel modeloTabla, modeloTablaResumen;
    private UsuarioDTO usuario;
    private String[] dias = {"TODOS", "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};
    private List<RutinaDTO> rutinas;
    private Observable observable;

    /**
     * Creates new form Menu
     */
    public Menu(Observable observable) {
        initComponents();
        iniciarComponentes();
        this.observable = observable;
        observable.addObserver(this);
    }
    
    private void iniciarComponentes() {
        rNegocio = new RutinaBO();
        uNegocio = new UsuariosBO();
        this.usuario = uNegocio.loginUsuario(SeguimientoEjercicioPresentacion.USUARIO);
        this.rutinas = rNegocio.obtenerRutinas(usuario);

        modeloTabla = new DefaultTableModel(new String[]{"Día", "Ejercicio", "Tipo", "Tiempo", "Estado"}, 0);
        modeloTablaResumen = new DefaultTableModel(new String[]{"Día", "Ejercicios Completos", "Ejercicios Pendientes", "Total Ejercicios", "Porcentaje"}, 0);

        tablaEjercicios.setModel(modeloTabla); 
        tblResumen.setModel(modeloTablaResumen); 

        txtNombreUsuario.setText(usuario.nomUsuario());
        txtNombreUsuario.setEditable(false);

        llenarComboBoxDias(); 
        llenarTabla(null); 
        llenarTablaResumen(); 

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarEjercicio = new javax.swing.JButton();
        btnModificarEjercicio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEjercicios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbxFiltroDias = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblResumen = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarEjercicio.setText("Agregar Ejercicio");
        btnAgregarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEjercicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarEjercicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 129, -1));

        btnModificarEjercicio.setText("Modificar Ejercicio");
        btnModificarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEjercicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificarEjercicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        tablaEjercicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Dia", "Ejercicio", "Tipo", "Tiempo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEjercicios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 425, 288));

        jLabel1.setText("Filtrar por dia");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        getContentPane().add(cbxFiltroDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 129, -1));

        tblResumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Dia", "Total ejercicios", "Ejercicios completados", "Ejercicios pendientes", "% Completo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblResumen);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 580, 100));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Resumen");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 600, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 30, 480));

        jLabel3.setText("Bienvenido");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        txtNombreUsuario.setBackground(new java.awt.Color(204, 204, 204));
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void llenarComboBoxDias() {
        for (String dia : dias) {
            cbxFiltroDias.addItem(dia);
        }
        
        cbxFiltroDias.addActionListener(evt -> {
            String diaSeleccionado = (String) cbxFiltroDias.getSelectedItem();
            if ("TODOS".equals(diaSeleccionado)) {
                llenarTabla(null); 
            } else {
                llenarTabla(diaSeleccionado);
            }
        });
    }
    
    public void llenarTabla(String diaFiltro) {
        modeloTabla.setRowCount(0); // Limpia la tabla

        for (RutinaDTO rutina : rutinas) {
            if (diaFiltro == null || rutina.dia().nombre().equals(diaFiltro)) {
                for (EjercicioDiarioDTO ejercicio : rutina.ejerciciosDiarios()) {
                    Object[] fila = new Object[]{
                        rutina.dia().nombre(),
                        ejercicio.ejercicio().nombre(),
                        ejercicio.ejercicio().tipo(),
                        ejercicio.ejercicio().duracion(),
                        ejercicio.completado() ? "Completado" : "No completado"
                    };
                    modeloTabla.addRow(fila);
                }
            }
        }

        modeloTabla.fireTableDataChanged();
    }
    
    public void llenarTablaResumen() {
        modeloTablaResumen.setRowCount(0);

        Map<String, Integer> ejerciciosCompletos = new HashMap<>();
        Map<String, Integer> ejerciciosPendientes = new HashMap<>();
        Map<String, Integer> totalEjercicios = new HashMap<>();

        // Inicializar los mapas
        for (RutinaDTO rutina : rutinas) {
            String dia = rutina.dia().nombre();
            totalEjercicios.put(dia, 0);
            ejerciciosCompletos.put(dia, 0);
            ejerciciosPendientes.put(dia, 0);

            // Contar ejercicios por día
            for (EjercicioDiarioDTO ejercicio : rutina.ejerciciosDiarios()) {
                totalEjercicios.put(dia, totalEjercicios.get(dia) + 1);
                if (ejercicio.completado()) {
                    ejerciciosCompletos.put(dia, ejerciciosCompletos.get(dia) + 1);
                } else {
                    ejerciciosPendientes.put(dia, ejerciciosPendientes.get(dia) + 1);
                }
            }
        }

        String[] diasOrdenados = {"LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};

        // Llenar la tabla resumen
        for (String dia : diasOrdenados) {
            if (totalEjercicios.containsKey(dia)) {
                int total = totalEjercicios.get(dia);
                int completos = ejerciciosCompletos.get(dia);
                int pendientes = ejerciciosPendientes.get(dia);
                double porcentaje = total > 0 ? (completos * 100.0) / total : 0;

                Object[] fila = new Object[]{
                    dia,
                    completos,
                    pendientes,
                    total,
                    String.format("%.2f%%", porcentaje) // Formatea el porcentaje
                };
                modeloTablaResumen.addRow(fila);
            }
        }

        modeloTablaResumen.fireTableDataChanged();
    }
    
    private void btnAgregarEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEjercicioActionPerformed
        RegistroEjercicio registroEjercicio = new RegistroEjercicio(observable);
        registroEjercicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarEjercicioActionPerformed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void btnModificarEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEjercicioActionPerformed
        // TODO add your handling code here:
        ModificarEjercicio me = new ModificarEjercicio(observable);
        me.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnModificarEjercicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEjercicio;
    private javax.swing.JButton btnModificarEjercicio;
    private javax.swing.JComboBox<String> cbxFiltroDias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaEjercicios;
    private javax.swing.JTable tblResumen;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        // Limpiar los modelos de tabla antes de volver a llenarlos
        modeloTabla.setRowCount(0);
        modeloTablaResumen.setRowCount(0);

        // Volver a cargar los datos desde la base de datos
        this.rutinas = rNegocio.obtenerRutinas(usuario);

        llenarTabla(null);
        llenarTablaResumen();
        System.out.println("Se actualizo");
    }
}
