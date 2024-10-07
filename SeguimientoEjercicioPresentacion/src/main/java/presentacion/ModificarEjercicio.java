package presentacion;

import dtos.EjercicioDTO;
import dtos.EjercicioDiarioDTO;
import dtos.RutinaDTO;
import dtos.UsuarioDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import negocio.IEjercicioDiarioBO;
import negocio.IRutinaBO;
import negocio.IUsuarioBO;
import negocio.RutinaBO;
import negocio.UsuariosBO;

/**
 *
 * @author alex_
 */
public class ModificarEjercicio extends javax.swing.JFrame {

    private UsuarioDTO usuario;
    private IUsuarioBO uNegocio;
    private IRutinaBO rNegocio;
    private EjercicioDTO ejercicioSeleccionado;
    private IEjercicioDiarioBO eNegocio;
    
    /**
     * Creates new form ModificarEjercicio
     */
    public ModificarEjercicio() {
        initComponents();
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        this.uNegocio = new UsuariosBO();
        this.usuario = uNegocio.loginUsuario(SeguimientoEjercicioPresentacion.USUARIO);
        this.rNegocio = new RutinaBO();
        obtenerEjerciciosCbx();
        
        cbxEjercicios.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cargarDatosEjercicio(cbxEjercicios.getSelectedItem().toString());
        }
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        checkLunes = new javax.swing.JCheckBox();
        checkMartes = new javax.swing.JCheckBox();
        checkMiercoles = new javax.swing.JCheckBox();
        checkJueves = new javax.swing.JCheckBox();
        checkViernes = new javax.swing.JCheckBox();
        checkSabado = new javax.swing.JCheckBox();
        checkDomingo = new javax.swing.JCheckBox();
        btEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbxEjercicios = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel2.setText("Modificar Ejercicios");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel3.setText("Tipo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel4.setText("Duración:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 240, -1));
        getContentPane().add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 240, -1));
        getContentPane().add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 240, -1));

        checkLunes.setText("Lunes");
        getContentPane().add(checkLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        checkMartes.setText("Martes");
        getContentPane().add(checkMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        checkMiercoles.setText("Miercoles");
        getContentPane().add(checkMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        checkJueves.setText("Jueves");
        getContentPane().add(checkJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        checkViernes.setText("Viernes");
        getContentPane().add(checkViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        checkSabado.setText("Sabado");
        getContentPane().add(checkSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        checkDomingo.setText("Domingo");
        getContentPane().add(checkDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jLabel5.setText("Dias de ejercicio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 40, 420));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        jLabel6.setText("Seleccionar el ejercicio a modificar o eliminar");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        getContentPane().add(cbxEjercicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void obtenerEjerciciosCbx() {
        List<RutinaDTO> rutinas = rNegocio.obtenerRutinas(usuario);
        List<EjercicioDTO> ejercicios = new ArrayList<>();

        for (RutinaDTO r : rutinas) {
            for (EjercicioDiarioDTO e : r.ejerciciosDiarios()) {
                EjercicioDTO ejercicioEncontrado = e.ejercicio();
                // Verificar si el ejercicio ya existe en la lista
                if (!ejercicios.contains(ejercicioEncontrado)) {
                    ejercicios.add(ejercicioEncontrado);
                    cbxEjercicios.addItem(ejercicioEncontrado.nombre()); 
                }
            }
        }
    }
    
    private void cargarDatosEjercicio(String nombreEjercicio) {
        // Obtener las rutinas del usuario
        List<RutinaDTO> rutinas = rNegocio.obtenerRutinas(usuario);

        // Limpiar los campos de texto antes de cargar nuevos datos
        txtNombre.setText("");
        txtTipo.setText("");
        txtDuracion.setText("");

        // Desmarcar todos los días al inicio
        checkLunes.setSelected(false);
        checkMartes.setSelected(false);
        checkMiercoles.setSelected(false);
        checkJueves.setSelected(false);
        checkViernes.setSelected(false);
        checkSabado.setSelected(false);
        checkDomingo.setSelected(false);

        // Recorrer sobre las rutinas
        for (RutinaDTO rutina : rutinas) {
            // Recorrer sobre los ejercicios diarios de cada rutina
            for (EjercicioDiarioDTO ejercicioDiario : rutina.ejerciciosDiarios()) {
                EjercicioDTO ejercicio = ejercicioDiario.ejercicio();
                // Verificar si el nombre del ejercicio coincide
                if (ejercicio.nombre().equals(nombreEjercicio)) {
                    // Llenar los campos de texto con los datos del ejercicio
                    txtNombre.setText(ejercicio.nombre());
                    txtTipo.setText(ejercicio.tipo());
                    txtDuracion.setText(String.valueOf(ejercicio.duracion())); // Asumiendo que duracion es un número
                    
                    this.ejercicioSeleccionado = ejercicio;

                    // Marcar los días de la semana en los que el ejercicio está registrado
                    String dia = rutina.dia().nombre(); 
                    switch (dia) {
                        case "LUNES":
                            checkLunes.setSelected(true);
                            break;
                        case "MARTES":
                            checkMartes.setSelected(true);
                            break;
                        case "MIERCOLES":
                            checkMiercoles.setSelected(true);
                            break;
                        case "JUEVES":
                            checkJueves.setSelected(true);
                            break;
                        case "VIERNES":
                            checkViernes.setSelected(true);
                            break;
                        case "SABADO":
                            checkSabado.setSelected(true);
                            break;
                        case "DOMINGO":
                            checkDomingo.setSelected(true);
                            break;
                    }
                }
            }
        }
    }
    
    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        System.out.println(this.ejercicioSeleccionado.id());
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void actualizarEjercicioBase(){
        
        String nombreNuevo = txtNombre.getText();
        String tipoNuevo = txtTipo.getText();
        float duracionNuevo = Float.parseFloat(txtDuracion.getText());
        
        EjercicioDTO ejModificado = new EjercicioDTO(
                ejercicioSeleccionado.id(), 
                nombreNuevo, 
                tipoNuevo, 
                duracionNuevo);
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxEjercicios;
    private javax.swing.JCheckBox checkDomingo;
    private javax.swing.JCheckBox checkJueves;
    private javax.swing.JCheckBox checkLunes;
    private javax.swing.JCheckBox checkMartes;
    private javax.swing.JCheckBox checkMiercoles;
    private javax.swing.JCheckBox checkSabado;
    private javax.swing.JCheckBox checkViernes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
