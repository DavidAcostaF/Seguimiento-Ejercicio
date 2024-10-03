/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dtos.EjercicioDTO;
import dtos.EjercicioDiarioDTO;
import dtos.RutinaDTO;
import dtos.UsuarioDTO;
import negocio.DiaBO;
import negocio.EjercicioBO;
import negocio.EjercicioDiarioBO;
import negocio.IDiaBO;
import negocio.IEjercicioBO;
import negocio.IEjercicioDiarioBO;
import negocio.IRutinaBO;
import negocio.RutinaBO;

/**
 *
 * @author af_da
 */
public class RegistroEjercicio extends javax.swing.JFrame {
    private IEjercicioBO ejercicioBO;
    private IRutinaBO rutinaBO;
    private IEjercicioDiarioBO ejercicioDiarioBO;
    private IDiaBO diaBO;
    private UsuarioDTO usuario = SeguimientoEjercicioPresentacion.USUARIO;

    /**
     * Creates new form RegistroEjercicio
     */
    public RegistroEjercicio() {
        initComponents();
        ejercicioBO = new EjercicioBO();    
        rutinaBO = new RutinaBO();
        diaBO = new DiaBO();
        ejercicioDiarioBO = new EjercicioDiarioBO();
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
        btnCrear = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Crear ejercicio");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Duración:");

        checkLunes.setText("Lunes");

        checkMartes.setText("Martes");

        checkMiercoles.setText("Miercoles");

        checkJueves.setText("Jueves");

        checkViernes.setText("Viernes");

        checkSabado.setText("Sabado");

        checkDomingo.setText("Domingo");
        checkDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDomingoActionPerformed(evt);
            }
        });

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jButton2.setText("Crear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jLabel2)
                .addContainerGap(300, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrear)
                .addGap(121, 121, 121))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkMiercoles)
                            .addComponent(checkLunes)
                            .addComponent(checkViernes)
                            .addComponent(checkDomingo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkSabado)
                            .addComponent(checkJueves)
                            .addComponent(checkMartes)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtDuracion))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre)
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(248, 248, 248))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkLunes)
                    .addComponent(checkMartes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkMiercoles)
                    .addComponent(checkJueves))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkViernes)
                    .addComponent(checkSabado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkDomingo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(jButton2))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDomingoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkDomingoActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        EjercicioDTO ejercicioCreado = this.crearEjercicio();
        
        boolean lunesSeleccionado = checkLunes.isSelected();
        boolean martesSeleccionado = checkMartes.isSelected();
        boolean miercolesSeleccionado = checkMiercoles.isSelected();
        boolean juevesSeleccionado = checkJueves.isSelected();
        boolean viernesSeleccionado = checkViernes.isSelected();
        boolean sabadoSeleccionado = checkSabado.isSelected();
        boolean domingoSeleccionado = checkDomingo.isSelected();
        
        System.out.println(ejercicioCreado);
        
        // Lunes
        if (checkLunes.isSelected()) {
            RutinaDTO rutinaDtoLunes = rutinaBO.obtenerRutina(usuario, diaBO.obtenerNumeroDia("Lunes"));
            EjercicioDiarioDTO ejercicioDiarioDTO = new EjercicioDiarioDTO(-1L, ejercicioCreado, false, rutinaDtoLunes);
            ejercicioDiarioBO.crearEjercicioDiario(ejercicioDiarioDTO);
        }

        // Martes
        if (checkMartes.isSelected()) {
            RutinaDTO rutinaDtoMartes = rutinaBO.obtenerRutina(usuario, diaBO.obtenerNumeroDia("Martes"));
            EjercicioDiarioDTO ejercicioDiarioDTO = new EjercicioDiarioDTO(-1L, ejercicioCreado, false, rutinaDtoMartes);
            ejercicioDiarioBO.crearEjercicioDiario(ejercicioDiarioDTO);
        }

        // Miércoles
        if (checkMiercoles.isSelected()) {
            RutinaDTO rutinaDtoMiercoles = rutinaBO.obtenerRutina(usuario, diaBO.obtenerNumeroDia("Miércoles"));
            EjercicioDiarioDTO ejercicioDiarioDTO = new EjercicioDiarioDTO(-1L, ejercicioCreado, false, rutinaDtoMiercoles);
            ejercicioDiarioBO.crearEjercicioDiario(ejercicioDiarioDTO);
        }

        // Jueves
        if (checkJueves.isSelected()) {
            RutinaDTO rutinaDtoJueves = rutinaBO.obtenerRutina(usuario, diaBO.obtenerNumeroDia("Jueves"));
            EjercicioDiarioDTO ejercicioDiarioDTO = new EjercicioDiarioDTO(-1L, ejercicioCreado, false, rutinaDtoJueves);
            ejercicioDiarioBO.crearEjercicioDiario(ejercicioDiarioDTO);
        }

        // Viernes
        if (checkViernes.isSelected()) {
            RutinaDTO rutinaDtoViernes = rutinaBO.obtenerRutina(usuario, diaBO.obtenerNumeroDia("Viernes"));
            EjercicioDiarioDTO ejercicioDiarioDTO = new EjercicioDiarioDTO(-1L, ejercicioCreado, false, rutinaDtoViernes);
            ejercicioDiarioBO.crearEjercicioDiario(ejercicioDiarioDTO);
        }

        // Sábado
        if (checkSabado.isSelected()) {
            RutinaDTO rutinaDtoSabado = rutinaBO.obtenerRutina(usuario, diaBO.obtenerNumeroDia("Sábado"));
            EjercicioDiarioDTO ejercicioDiarioDTO = new EjercicioDiarioDTO(-1L, ejercicioCreado, false, rutinaDtoSabado);
            ejercicioDiarioBO.crearEjercicioDiario(ejercicioDiarioDTO);
        }

        // Domingo
        if (checkDomingo.isSelected()) {
            RutinaDTO rutinaDtoDomingo = rutinaBO.obtenerRutina(usuario, diaBO.obtenerNumeroDia("Domingo"));
            EjercicioDiarioDTO ejercicioDiarioDTO = new EjercicioDiarioDTO(-1L, ejercicioCreado, false, rutinaDtoDomingo);
            ejercicioDiarioBO.crearEjercicioDiario(ejercicioDiarioDTO);
        }
        Menu menu = new Menu();
        menu.llenarTabla(null);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private EjercicioDTO crearEjercicio(){
        String nombre = txtNombre.getText();
        String tipo = txtTipo.getText();
        String duracion = txtDuracion.getText();
        EjercicioDTO ejercicioDTO = new EjercicioDTO(-1L, nombre, tipo, Float.parseFloat(duracion));
        return ejercicioBO.crearEjercicio(ejercicioDTO);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JCheckBox checkDomingo;
    private javax.swing.JCheckBox checkJueves;
    private javax.swing.JCheckBox checkLunes;
    private javax.swing.JCheckBox checkMartes;
    private javax.swing.JCheckBox checkMiercoles;
    private javax.swing.JCheckBox checkSabado;
    private javax.swing.JCheckBox checkViernes;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
