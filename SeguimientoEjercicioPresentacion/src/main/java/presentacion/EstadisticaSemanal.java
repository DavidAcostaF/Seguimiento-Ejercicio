/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
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
public class EstadisticaSemanal extends javax.swing.JFrame {

    private IRutinaBO rNegocio;
    private IUsuarioBO uNegocio;
    private UsuarioDTO usuario;
    private DefaultTableModel modeloTabla, modeloTablaResumen;

    private List<RutinaDTO> rutinas;

    /**
     * Creates new form EstadisticaSemanal
     */
    public EstadisticaSemanal() {
        initComponents();
        this.uNegocio = new UsuariosBO();
        this.rNegocio = new RutinaBO();
        this.usuario = uNegocio.loginUsuario(SeguimientoEjercicioPresentacion.USUARIO);
        this.rutinas = rNegocio.obtenerRutinas(usuario);
        modeloTablaResumen = new DefaultTableModel(new String[]{"Día", "Ejercicios Completos", "Ejercicios Pendientes", "Total Ejercicios", "Porcentaje"}, 0);
        tblResumen.setModel(modeloTablaResumen);
        llenarTablaResumen();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblResumen = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Estadisitica semanal");

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

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 55, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 55, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 43, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 234, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblResumen;
    // End of variables declaration//GEN-END:variables
}
