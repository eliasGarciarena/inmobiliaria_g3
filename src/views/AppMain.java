/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import data.Conexion;
import data.InmuebleData;
import data.InquilinoData;
import data.PropietarioData;
import entities.Inmueble;
import entities.Inquilino;
import entities.Propietario;

import javax.swing.JOptionPane;

/**
 *
 * @author agusv
 */
public class AppMain extends javax.swing.JFrame {

    /**
     * Creates new form AppMain
     */
    Conexion conn = new Conexion();

    ArrayList<Inquilino> inquilinoList = new ArrayList<>();
    ArrayList<Inmueble> inmuebleList = new ArrayList<>();
    ArrayList<Propietario> propietarioList = new ArrayList<>();
    InquilinoData inquilinoData;
    InmuebleData inmuebleData;
    PropietarioData propietarioData;

    DefaultTableModel tableModel = new DefaultTableModel();

    public AppMain() {
        initComponents();

        inquilinoData = new InquilinoData(conn);
        inmuebleData = new InmuebleData(conn);
        propietarioData = new PropietarioData(conn);

        inquilinoList = inquilinoData.obtenerInquilinos();
        inmuebleList = inmuebleData.ObtenerInmuebles();
        propietarioList = propietarioData.obtenerPropietarios();

        cargarTablaInquilinos();
        cargarTablaInmueble();
        cargarTablaPropietario();
    }

    public void cargarTablaInquilinos() {
        DefaultTableModel tableModel = (DefaultTableModel) tablaInquilinos.getModel();
        // Limpiamos la tabla
        int filas = tablaInquilinos.getRowCount();
        for (int i = 0; filas > i; i++) {
            tableModel.removeRow(0);
        }

        // Cargamos nuevos datos a la tabla
        for (Inquilino inquilinoAux : inquilinoList) {
            tableModel
                    .insertRow(inquilinoList.indexOf(inquilinoAux), new Object[] {
                            inquilinoAux.getId(),
                            inquilinoAux.getNombre(),
                            inquilinoAux.getApellido(),
                            inquilinoAux.getDni(),
                            inquilinoAux.getCuit(),
                            inquilinoAux.getTelefono(),
                            "VER" });
        }
    }

    // TABLA INMUEBLE
    public void cargarTablaInmueble() {
        DefaultTableModel tableModel = (DefaultTableModel) tablaInmuebles.getModel();
        // Limpiamos la tabla
        int filas = tablaInmuebles.getRowCount();
        for (int i = 0; filas > i; i++) {
            tableModel.removeRow(0);
        }

        // Cargamos nuevos datos a la tabla
        for (Inmueble inmuebleAux : inmuebleList) {
            tableModel
                    .insertRow(inmuebleList.indexOf(inmuebleAux), new Object[] {
                            // public Inmueble(int id, Propietario propietario, String direccion, String
                            // zona, String tipoInmueble, String estadoInmueble, double precio, double
                            // superficie, boolean activo) {
                            inmuebleAux.getId(),
                            inmuebleAux.getZona(),
                            inmuebleAux.getDireccion(),
                            inmuebleAux.getTipoInmueble(),
                            inmuebleAux.getEstadoInmueble(),
                            inmuebleAux.getSuperficie(),
                            inmuebleAux.getPrecio(),
                            "VER" });
        }
    }

    // TABLA PROPIETARIO
    public void cargarTablaPropietario() {
        DefaultTableModel tableModel = (DefaultTableModel) tablaPropietarios.getModel();
        // Limpiamos la tabla
        int filas = tablaPropietarios.getRowCount();
        for (int i = 0; filas > i; i++) {
            tableModel.removeRow(0);
        }

        // Cargamos nuevos datos a la tabla
        for (Propietario propietarioAux : propietarioList) {
            tableModel
                    .insertRow(propietarioList.indexOf(propietarioAux), new Object[] {
                            // public Inmueble(int id, Propietario propietario, String direccion, String
                            // zona, String tipoInmueble, String estadoInmueble, double precio, double
                            // superficie, boolean activo) {
                            propietarioAux.getId(),
                            propietarioAux.getNombre(),
                            propietarioAux.getApellido(),
                            propietarioAux.getDni(),
                            propietarioAux.getDomicilio(),
                            propietarioAux.getTelefono(),
                            "VER" });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupInmueble = new javax.swing.ButtonGroup();
        btnGrupInquilinos = new javax.swing.ButtonGroup();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanelInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JPanelInmuebles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInmuebles = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rbtnInmueblesAlquilados = new javax.swing.JRadioButton();
        rbtnInmueblesLibres = new javax.swing.JRadioButton();
        rbtnInmueblesTodos = new javax.swing.JRadioButton();
        btnAgregarInmueble = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txfBuscarInmueble = new javax.swing.JTextField();
        btnBuscarInmueble = new javax.swing.JButton();
        selectBuscarInmueble = new javax.swing.JComboBox<>();
        btnLimpiarBuscarInmueble = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInquilinos = new javax.swing.JTable();
        btnAgregarInquilino = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rbtnInquilinoActivos = new javax.swing.JRadioButton();
        rbtnInquilinoInactivos = new javax.swing.JRadioButton();
        rbtnInquilinoTodos = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnAgregarPropietario = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPropietarios = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Inciio");

        javax.swing.GroupLayout jPanelInicioLayout = new javax.swing.GroupLayout(jPanelInicio);
        jPanelInicio.setLayout(jPanelInicioLayout);
        jPanelInicioLayout.setHorizontalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioLayout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(619, Short.MAX_VALUE))
        );
        jPanelInicioLayout.setVerticalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(462, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Inicio", jPanelInicio);

        tablaInmuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ZONA", "DIRECCION", "TIPO", "ESTADO", "SUP. m2", "PRECIO", "VER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInmuebles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInmueblesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInmuebles);
        if (tablaInmuebles.getColumnModel().getColumnCount() > 0) {
            tablaInmuebles.getColumnModel().getColumn(7).setResizable(false);
            tablaInmuebles.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        jLabel2.setText("Mostrar:");

        btnGrupInmueble.add(rbtnInmueblesAlquilados);
        rbtnInmueblesAlquilados.setText("Alquilados");
        rbtnInmueblesAlquilados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInmueblesAlquiladosActionPerformed(evt);
            }
        });

        btnGrupInmueble.add(rbtnInmueblesLibres);
        rbtnInmueblesLibres.setText("Libres");
        rbtnInmueblesLibres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInmueblesLibresActionPerformed(evt);
            }
        });

        btnGrupInmueble.add(rbtnInmueblesTodos);
        rbtnInmueblesTodos.setSelected(true);
        rbtnInmueblesTodos.setText("Todos");
        rbtnInmueblesTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInmueblesTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnInmueblesAlquilados, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnInmueblesLibres, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnInmueblesTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnInmueblesAlquilados)
                    .addComponent(rbtnInmueblesLibres)
                    .addComponent(rbtnInmueblesTodos))
                .addGap(21, 21, 21))
        );

        btnAgregarInmueble.setText("Agregar Inmueble");
        btnAgregarInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInmuebleActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setText("Buscar Inmueble");

        btnBuscarInmueble.setText("Buscar");
        btnBuscarInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarInmuebleActionPerformed(evt);
            }
        });

        selectBuscarInmueble.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por ID", "Buscar por Zona", "Buscar por Propietario", "Buscar por Precio Menor" }));

        btnLimpiarBuscarInmueble.setText("Limpiar");
        btnLimpiarBuscarInmueble.setEnabled(false);
        btnLimpiarBuscarInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarBuscarInmuebleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectBuscarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnBuscarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiarBuscarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txfBuscarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectBuscarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfBuscarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarInmueble)
                    .addComponent(btnLimpiarBuscarInmueble))
                .addContainerGap())
        );

        javax.swing.GroupLayout JPanelInmueblesLayout = new javax.swing.GroupLayout(JPanelInmuebles);
        JPanelInmuebles.setLayout(JPanelInmueblesLayout);
        JPanelInmueblesLayout.setHorizontalGroup(
            JPanelInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(JPanelInmueblesLayout.createSequentialGroup()
                .addGroup(JPanelInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelInmueblesLayout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelInmueblesLayout.createSequentialGroup()
                        .addGap(404, 404, 404)
                        .addComponent(btnAgregarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JPanelInmueblesLayout.setVerticalGroup(
            JPanelInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelInmueblesLayout.createSequentialGroup()
                .addGroup(JPanelInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelInmueblesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAgregarInmueble)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelInmueblesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("Inmuebles", JPanelInmuebles);

        tablaInquilinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "DNI", "CUIT", "TELEFONO", "VER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInquilinos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInquilinosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaInquilinos);
        if (tablaInquilinos.getColumnModel().getColumnCount() > 0) {
            tablaInquilinos.getColumnModel().getColumn(0).setPreferredWidth(40);
            tablaInquilinos.getColumnModel().getColumn(1).setPreferredWidth(60);
            tablaInquilinos.getColumnModel().getColumn(2).setPreferredWidth(60);
            tablaInquilinos.getColumnModel().getColumn(3).setPreferredWidth(60);
            tablaInquilinos.getColumnModel().getColumn(4).setPreferredWidth(60);
            tablaInquilinos.getColumnModel().getColumn(5).setMinWidth(60);
            tablaInquilinos.getColumnModel().getColumn(5).setPreferredWidth(60);
            tablaInquilinos.getColumnModel().getColumn(6).setResizable(false);
            tablaInquilinos.getColumnModel().getColumn(6).setPreferredWidth(30);
        }

        btnAgregarInquilino.setText("Agregar Inquilino");
        btnAgregarInquilino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInquilinoActionPerformed(evt);
            }
        });

        jLabel3.setText("Mostrar:");

        btnGrupInquilinos.add(rbtnInquilinoActivos);
        rbtnInquilinoActivos.setText("Activos");
        rbtnInquilinoActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInquilinoActivosActionPerformed(evt);
            }
        });

        btnGrupInquilinos.add(rbtnInquilinoInactivos);
        rbtnInquilinoInactivos.setText("Inactivos");
        rbtnInquilinoInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInquilinoInactivosActionPerformed(evt);
            }
        });

        btnGrupInquilinos.add(rbtnInquilinoTodos);
        rbtnInquilinoTodos.setSelected(true);
        rbtnInquilinoTodos.setText("Todos");
        rbtnInquilinoTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnInquilinoTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnInquilinoActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnInquilinoInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnInquilinoTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnInquilinoActivos)
                    .addComponent(rbtnInquilinoInactivos)
                    .addComponent(rbtnInquilinoTodos))
                .addGap(21, 21, 21))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setText("Buscar Inquilino");

        jButton4.setText("Buscar");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por ID", "Buscar por Dni", "Buscar por Nombre", "Buscar por Apellido" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(btnAgregarInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAgregarInquilino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane6.addTab("Inquilinos", jPanel3);

        btnAgregarPropietario.setText("Agregar Propietario");
        btnAgregarPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPropietarioActionPerformed(evt);
            }
        });

        tablaPropietarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "DNI", "DOMICILIO", "TELEFONO", "VER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPropietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPropietariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaPropietarios);
        if (tablaPropietarios.getColumnModel().getColumnCount() > 0) {
            tablaPropietarios.getColumnModel().getColumn(0).setPreferredWidth(40);
            tablaPropietarios.getColumnModel().getColumn(1).setPreferredWidth(60);
            tablaPropietarios.getColumnModel().getColumn(2).setPreferredWidth(60);
            tablaPropietarios.getColumnModel().getColumn(3).setPreferredWidth(60);
            tablaPropietarios.getColumnModel().getColumn(4).setPreferredWidth(60);
            tablaPropietarios.getColumnModel().getColumn(5).setMinWidth(60);
            tablaPropietarios.getColumnModel().getColumn(5).setPreferredWidth(60);
            tablaPropietarios.getColumnModel().getColumn(6).setResizable(false);
            tablaPropietarios.getColumnModel().getColumn(6).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(btnAgregarPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(531, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnAgregarPropietario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane6.addTab("Propietario", jPanel4);

        jButton1.setText("Agregar Contrato");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(473, 473, 473)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(471, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(426, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Contrato", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPropietarioActionPerformed
        // TODO add your handling code here:
        PropietarioView propietarioView = new PropietarioView(this, true, conn);
        propietarioView.setVisible(true);
    }//GEN-LAST:event_btnAgregarPropietarioActionPerformed

    private void tablaPropietariosMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tablaPropietariosMouseClicked
        // TODO add your handling code here:
        javax.swing.JTable tableSource = (javax.swing.JTable) evt.getSource();
        int fila = tableSource.rowAtPoint(evt.getPoint());
        int columna = tableSource.columnAtPoint(evt.getPoint());
        if (columna == tableSource.getColumnModel().getColumnCount() - 1) {
            PropietarioView propietarioView = new PropietarioView(this, true, conn, propietarioList.get(fila));
            propietarioView.setVisible(true);
        }
    }// GEN-LAST:event_tablaPropietariosMouseClicked

    private void btnLimpiarBuscarInmuebleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLimpiarBuscarInmuebleActionPerformed
        // TODO add your handling code here:
        inmuebleList = inmuebleData.ObtenerInmuebles();
        cargarTablaInmueble();
        txfBuscarInmueble.setText("");
        btnLimpiarBuscarInmueble.setEnabled(false);
        rbtnInmueblesTodos.setSelected(true);
    }// GEN-LAST:event_btnLimpiarBuscarInmuebleActionPerformed

    private void rbtnInmueblesTodosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbtnInmueblesTodosActionPerformed
        // TODO add your handling code here:
        if (rbtnInmueblesTodos.isSelected()) {
            inmuebleList = inmuebleData.ObtenerInmuebles();
            cargarTablaInmueble();
        }
    }// GEN-LAST:event_rbtnInmueblesTodosActionPerformed

    private void rbtnInmueblesLibresActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbtnInmueblesLibresActionPerformed
        // TODO add your handling code here:
        if (rbtnInmueblesLibres.isSelected()) {
            inmuebleList = inmuebleData.ObtenerInmueblesLibres();
            cargarTablaInmueble();
        }
    }// GEN-LAST:event_rbtnInmueblesLibresActionPerformed

    private void rbtnInmueblesAlquiladosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbtnInmueblesAlquiladosActionPerformed
        // TODO add your handling code here:
        if (rbtnInmueblesAlquilados.isSelected()) {
            inmuebleList = inmuebleData.ObtenerInmueblesAlquilados();
            cargarTablaInmueble();
        }
    }// GEN-LAST:event_rbtnInmueblesAlquiladosActionPerformed

    private void tablaInmueblesMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tablaInmueblesMouseClicked
        // TODO add your handling code here:
        javax.swing.JTable tableSource = (javax.swing.JTable) evt.getSource();
        int fila = tableSource.rowAtPoint(evt.getPoint());
        int columna = tableSource.columnAtPoint(evt.getPoint());
        if (columna == tableSource.getColumnModel().getColumnCount() - 1) {
            InmuebleView inmuebleView = new InmuebleView(this, true, conn, inmuebleList.get(fila).getId());
            inmuebleView.setVisible(true);
        }
    }// GEN-LAST:event_tablaInmueblesMouseClicked

    private void btnAgregarInmuebleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarInmuebleActionPerformed
        // TODO add your handling code here:
        InmuebleView inmuebleView = new InmuebleView(this, true, conn);
        inmuebleView.setVisible(true);
    }// GEN-LAST:event_btnAgregarInmuebleActionPerformed

    private void btnBuscarInmuebleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarInmuebleActionPerformed
        // TODO add your handling code here:
        ArrayList<Inmueble> listAux = new ArrayList<>(inmuebleList);
        inmuebleList.clear();
        String selectValue = selectBuscarInmueble.getSelectedItem().toString();
        String value = txfBuscarInmueble.getText();
        switch (selectValue) {
            case "Buscar por ID":
                try {
                    Inmueble inmueble = inmuebleData.obtenerInmuebleXId(Integer.parseInt(value));
                    if (inmueble != null) {
                        inmuebleList.add(inmueble);
                        cargarTablaInmueble();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encuentra el id ingresado");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor incorrecto");
                }

                break;
            case "Buscar por Zona":
                for (Inmueble inmuebleAux : listAux) {
                    if (inmuebleAux.getZona().equalsIgnoreCase(value)) {
                        inmuebleList.add(inmuebleAux);
                    }
                }
                if (inmuebleList.size() != 0) {
                    cargarTablaInmueble();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encuentro ningun inmueble en esa zona");
                }
                break;
            case "Buscar por Propietario":
                for (Inmueble inmuebleAux : listAux) {
                    if (inmuebleAux.getPropietario().getNombre().equalsIgnoreCase(value)
                            || inmuebleAux.getPropietario().getApellido().equalsIgnoreCase(value)) {
                        inmuebleList.add(inmuebleAux);
                    }
                }
                if (inmuebleList.size() != 0) {
                    cargarTablaInmueble();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encuentro ningun inmueble con ese nombre o apellido");
                }
                break;

            case "Buscar por Precio Menor":
                try {
                    for (Inmueble inmuebleAux : listAux) {
                        if (inmuebleAux.getPrecio() <= Integer.parseInt(value)) {
                            inmuebleList.add(inmuebleAux);
                        }
                    }
                    if (inmuebleList.size() != 0) {
                        cargarTablaInmueble();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "No se encuentro ningun inmueble con precio menor a " + value);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor incorrecto");
                }
                break;
            default:
                throw new AssertionError();
        }
        btnLimpiarBuscarInmueble.setEnabled(true);
        inmuebleList = listAux;
    }// GEN-LAST:event_btnBuscarInmuebleActionPerformed

    private void tablaInquilinosMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tablaInquilinosMouseClicked
        // TODO add your handling code here:
        javax.swing.JTable tableSource = (javax.swing.JTable) evt.getSource();
        int fila = tableSource.rowAtPoint(evt.getPoint());
        int columna = tableSource.columnAtPoint(evt.getPoint());
        if (columna == tableSource.getColumnModel().getColumnCount() - 1) {
            InquilinoView inquilinoView = new InquilinoView(this, true, conn, inquilinoList.get(fila).getId());
            inquilinoView.setVisible(true);
        }
    }// GEN-LAST:event_tablaInquilinosMouseClicked

    private void rbtnInquilinoTodosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbtnInquilinoTodosActionPerformed
        // TODO add your handling code here:
        if (rbtnInquilinoTodos.isSelected()) {
            inquilinoList = inquilinoData.obtenerInquilinos();
            cargarTablaInquilinos();
        }
    }// GEN-LAST:event_rbtnInquilinoTodosActionPerformed

    private void rbtnInquilinoActivosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbtnInquilinoActivosActionPerformed
        // TODO add your handling code here:
        if (rbtnInquilinoActivos.isSelected()) {
            inquilinoList = inquilinoData.obtenerInquilinosActivos();
            cargarTablaInquilinos();
        }

    }// GEN-LAST:event_rbtnInquilinoActivosActionPerformed

    private void rbtnInquilinoInactivosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbtnInquilinoInactivosActionPerformed
        // TODO add your handling code here:
        if (rbtnInquilinoInactivos.isSelected()) {
            inquilinoList = inquilinoData.obtenerInquilinosInactivos();
            cargarTablaInquilinos();
        }
    }// GEN-LAST:event_rbtnInquilinoInactivosActionPerformed

    private void btnAgregarInquilinoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarInquilinoActionPerformed
        // TODO add your handling code here:
        InquilinoView inquilinoView = new InquilinoView(this, true, conn);
        inquilinoView.setVisible(true);
    }// GEN-LAST:event_btnAgregarInquilinoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelInmuebles;
    private javax.swing.JButton btnAgregarInmueble;
    private javax.swing.JButton btnAgregarInquilino;
    private javax.swing.JButton btnAgregarPropietario;
    private javax.swing.JButton btnBuscarInmueble;
    private javax.swing.ButtonGroup btnGrupInmueble;
    private javax.swing.ButtonGroup btnGrupInquilinos;
    private javax.swing.JButton btnLimpiarBuscarInmueble;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelInicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JRadioButton rbtnInmueblesAlquilados;
    private javax.swing.JRadioButton rbtnInmueblesLibres;
    private javax.swing.JRadioButton rbtnInmueblesTodos;
    private javax.swing.JRadioButton rbtnInquilinoActivos;
    private javax.swing.JRadioButton rbtnInquilinoInactivos;
    private javax.swing.JRadioButton rbtnInquilinoTodos;
    private javax.swing.JComboBox<String> selectBuscarInmueble;
    private javax.swing.JTable tablaInmuebles;
    private javax.swing.JTable tablaInquilinos;
    private javax.swing.JTable tablaPropietarios;
    private javax.swing.JTextField txfBuscarInmueble;
    // End of variables declaration//GEN-END:variables
}
