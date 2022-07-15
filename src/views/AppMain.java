package views;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import data.Conexion;
import data.ContratoData;
import data.InmuebleData;
import data.InquilinoData;
import data.PropietarioData;
import entities.Contrato_inmueble;
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
     * Crea nueva AppMain
     */
    Conexion conn = new Conexion();

    ArrayList<Inquilino> inquilinoList = new ArrayList<>();
    ArrayList<Inmueble> inmuebleList = new ArrayList<>();
    ArrayList<Propietario> propietarioList = new ArrayList<>();
    ArrayList<Contrato_inmueble> contratoList = new ArrayList<>();

    InquilinoData inquilinoData;
    InmuebleData inmuebleData;
    PropietarioData propietarioData;
    ContratoData contratoData;

    DefaultTableModel tableModel = new DefaultTableModel();

    public AppMain() {
        initComponents();

        inquilinoData = new InquilinoData(conn);
        inmuebleData = new InmuebleData(conn);
        propietarioData = new PropietarioData(conn);
        contratoData = new ContratoData(conn);

        inquilinoList = inquilinoData.obtenerInquilinos();
        inmuebleList = inmuebleData.ObtenerInmuebles();
        propietarioList = propietarioData.obtenerPropietarios();
        contratoList = contratoData.obtenerContratos();

        cargarTablaInquilinos();
        cargarTablaInmueble();
        cargarTablaPropietario();
        cargarTablaContratos();

        btnAlquiler.setEnabled(false);
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

    // TABLA PROPIETARIO
    public void cargarTablaContratos() {
        DefaultTableModel tableModel = (DefaultTableModel) tablaContratos.getModel();
        // Limpiamos la tabla
        int filas = tablaContratos.getRowCount();
        for (int i = 0; filas > i; i++) {
            tableModel.removeRow(0);
        }

        // Cargamos nuevos datos a la tabla
        for (Contrato_inmueble contratoAux : contratoList) {
            tableModel
                    .insertRow(contratoList.indexOf(contratoAux), new Object[] {
                            contratoAux.getId(),
                            contratoAux.getInqui().getId(),
                            contratoAux.getInmu().getId(),
                            contratoAux.getInmu().getPropietario().getId(),
                            contratoAux.getFechaInicio().toString(),
                            contratoAux.getFechaFinal().toString(),
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupInmueble = new javax.swing.ButtonGroup();
        btnGrupInquilinos = new javax.swing.ButtonGroup();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanelInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTotalInmueble = new javax.swing.JLabel();
        lblTotalPropietario = new javax.swing.JLabel();
        lblContratosVigentes = new javax.swing.JLabel();
        lblTotalInquilinos = new javax.swing.JLabel();
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
        btnAlquiler = new javax.swing.JButton();
        btnActualizarTablaInmueble = new javax.swing.JButton();
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
        txfBuscarInquilino = new javax.swing.JTextField();
        btnBuscarInquilino = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnActualizarTablaInquilinos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnAgregarPropietario = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPropietarios = new javax.swing.JTable();
        btnActualizarTablaPropietario = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        rbtnPropietarioTodos = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        btnAgregarContrato = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaContratos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Inicio");

        jLabel6.setText("Total Inquilinos");

        jLabel7.setText("Total Inmuebles");

        jLabel8.setText("Total Propietarios");

        jLabel9.setText("Contratos Vigentes");

        lblTotalInmueble.setText("Total Inmuebles");

        lblTotalPropietario.setText("Total Propietarios");

        lblContratosVigentes.setText("Contratos Vigentes");

        lblTotalInquilinos.setText("Total Inquilinos");

        javax.swing.GroupLayout jPanelInicioLayout = new javax.swing.GroupLayout(jPanelInicio);
        jPanelInicio.setLayout(jPanelInicioLayout);
        jPanelInicioLayout.setHorizontalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioLayout.createSequentialGroup()
                .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInicioLayout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInicioLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalInquilinos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContratosVigentes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(627, Short.MAX_VALUE))
        );
        jPanelInicioLayout.setVerticalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(82, 82, 82)
                .addGroup(jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInicioLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInicioLayout.createSequentialGroup()
                        .addComponent(lblTotalInquilinos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(lblContratosVigentes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(245, Short.MAX_VALUE))
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

        selectBuscarInmueble.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por ID", "Buscar por DNI Propietario" }));

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectBuscarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnBuscarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiarBuscarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txfBuscarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btnAlquiler.setText("Alquiler");
        btnAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlquilerActionPerformed(evt);
            }
        });

        btnActualizarTablaInmueble.setText("Actualizar Tabla");
        btnActualizarTablaInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTablaInmuebleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelInmueblesLayout = new javax.swing.GroupLayout(JPanelInmuebles);
        JPanelInmuebles.setLayout(JPanelInmueblesLayout);
        JPanelInmueblesLayout.setHorizontalGroup(
            JPanelInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(JPanelInmueblesLayout.createSequentialGroup()
                .addGroup(JPanelInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelInmueblesLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnActualizarTablaInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelInmueblesLayout.createSequentialGroup()
                        .addGap(404, 404, 404)
                        .addComponent(btnAgregarInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(JPanelInmueblesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAlquiler)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelInmueblesLayout.setVerticalGroup(
            JPanelInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelInmueblesLayout.createSequentialGroup()
                .addGroup(JPanelInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelInmueblesLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE))
                    .addGroup(JPanelInmueblesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAgregarInmueble)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(JPanelInmueblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelInmueblesLayout.createSequentialGroup()
                                .addComponent(btnActualizarTablaInmueble)
                                .addGap(21, 21, 21)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnAlquiler)
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

        btnBuscarInquilino.setText("Buscar");
        btnBuscarInquilino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarInquilinoActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por ID", "Buscar por DNI" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfBuscarInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnBuscarInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(txfBuscarInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarInquilino)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btnActualizarTablaInquilinos.setText("Actualizar Tabla");
        btnActualizarTablaInquilinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTablaInquilinosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnActualizarTablaInquilinos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(btnAgregarInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAgregarInquilino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarTablaInquilinos)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

        btnActualizarTablaPropietario.setText("Actualizar Tabla");
        btnActualizarTablaPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTablaPropietarioActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );

        rbtnPropietarioTodos.setText("Todos");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .addComponent(rbtnPropietarioTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(rbtnPropietarioTodos)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(406, 406, 406)
                        .addComponent(btnAgregarPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnActualizarTablaPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnAgregarPropietario)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnActualizarTablaPropietario)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane6.addTab("Propietario", jPanel4);

        btnAgregarContrato.setText("Agregar Contrato");
        btnAgregarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarContratoActionPerformed(evt);
            }
        });

        tablaContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID INQUILINO", "ID INMUEBLE", "ID PROPIETARIO", "FECHA INICIO", "FECHA FIN", "VER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaContratos);
        if (tablaContratos.getColumnModel().getColumnCount() > 0) {
            tablaContratos.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1119, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(477, 477, 477)
                .addComponent(btnAgregarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(btnAgregarContrato)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnAgregarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarContratoActionPerformed
        // TODO add your handling code here:
        ContratoView contratoView = new ContratoView(this, true, conn);
    }//GEN-LAST:event_btnAgregarContratoActionPerformed

    private void btnAgregarPropietarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarPropietarioActionPerformed
        // TODO add your handling code here:
        PropietarioView propietarioView = new PropietarioView(this, true, conn);
        propietarioView.setVisible(true);
    }// GEN-LAST:event_btnAgregarPropietarioActionPerformed

    private void btnAlquilerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAlquilerActionPerformed
        // TODO add your handling code here:
        Inmueble inmu = new Inmueble();
        try {
            int id = (int) tablaInmuebles.getValueAt(tablaInmuebles.getSelectedRow(), 0);
            inmu = inmuebleData.obtenerInmuebleXId(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "" + ex);
        }
        ContratoView con = new ContratoView(this, true, inmu, conn);
        con.setVisible(true);
    }// GEN-LAST:event_btnAlquilerActionPerformed

    private void btnBuscarInquilinoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarInquilinoActionPerformed
        // TODO add your handling code here:
        try {
            int value = Integer.parseInt(txfBuscarInquilino.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Valores invalidos\n" + ex);
        }
    }// GEN-LAST:event_btnBuscarInquilinoActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBox2ActionPerformed

    private void btnActualizarTablaInmuebleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnActualizarTablaInmuebleActionPerformed
        // TODO add your handling code here:
        inmuebleList = inmuebleData.ObtenerInmuebles();
        cargarTablaInmueble();
        rbtnInmueblesTodos.setSelected(true);
    }// GEN-LAST:event_btnActualizarTablaInmuebleActionPerformed

    private void btnActualizarTablaInquilinosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnActualizarTablaInquilinosActionPerformed
        // TODO add your handling code here:
        inquilinoList = inquilinoData.obtenerInquilinos();
        cargarTablaInquilinos();
        rbtnInquilinoTodos.setSelected(true);
    }// GEN-LAST:event_btnActualizarTablaInquilinosActionPerformed

    private void btnActualizarTablaPropietarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnActualizarTablaPropietarioActionPerformed
        // TODO add your handling code here:
        propietarioList = propietarioData.obtenerPropietarios();
        cargarTablaPropietario();
        rbtnPropietarioTodos.setSelected(true);
    }// GEN-LAST:event_btnActualizarTablaPropietarioActionPerformed

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
            inmuebleList = contratoData.InmueblesNoAlquilados();
            cargarTablaInmueble();
        }
    }// GEN-LAST:event_rbtnInmueblesLibresActionPerformed

    private void rbtnInmueblesAlquiladosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rbtnInmueblesAlquiladosActionPerformed
        // TODO add your handling code here:
        if (rbtnInmueblesAlquilados.isSelected()) {
            inmuebleList = contratoData.InmueblesAlquilados();
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
        if (tablaInmuebles.getSelectedColumn() > -1) {
            btnAlquiler.setEnabled(true);
        }
    }// GEN-LAST:event_tablaInmueblesMouseClicked

    private void btnAgregarInmuebleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarInmuebleActionPerformed
        // TODO add your handling code here:
        InmuebleView inmuebleView = new InmuebleView(this, true, conn);
        inmuebleView.setVisible(true);
    }// GEN-LAST:event_btnAgregarInmuebleActionPerformed

    private void btnBuscarInmuebleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarInmuebleActionPerformed
        // TODO add your handling code here:
        try {
            int value = Integer.parseInt(txfBuscarInmueble.getText());
            ArrayList<Inmueble> listAux = new ArrayList<>(inmuebleList);
            inmuebleList.clear();
            String selectValue = selectBuscarInmueble.getSelectedItem().toString();
            switch (selectValue) {
                case "Buscar por ID":
                    try {
                        Inmueble inmueble = inmuebleData.obtenerInmuebleXId(value);
                        if (inmueble != null) {
                            inmuebleList.add(inmueble);
                            cargarTablaInmueble();
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encuentra el ID ingresado");
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Valor incorrecto\n" + e);
                    }

                    break;
                case "Buscar por DNI Propietario":
                    for (Inmueble inmuebleAux : listAux) {
                        if (inmuebleAux.getPropietario().getDni() == value) {
                            inmuebleList.add(inmuebleAux);
                        }
                    }
                    if (inmuebleList.size() != 0) {
                        cargarTablaInmueble();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro ningun Inmueble con esos datos");
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            btnLimpiarBuscarInmueble.setEnabled(true);
            inmuebleList = listAux;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR: Valores invalidos\n" + ex);
        }
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
    private javax.swing.JButton btnActualizarTablaInmueble;
    private javax.swing.JButton btnActualizarTablaInquilinos;
    private javax.swing.JButton btnActualizarTablaPropietario;
    private javax.swing.JButton btnAgregarContrato;
    private javax.swing.JButton btnAgregarInmueble;
    private javax.swing.JButton btnAgregarInquilino;
    private javax.swing.JButton btnAgregarPropietario;
    private javax.swing.JButton btnAlquiler;
    private javax.swing.JButton btnBuscarInmueble;
    private javax.swing.JButton btnBuscarInquilino;
    private javax.swing.ButtonGroup btnGrupInmueble;
    private javax.swing.ButtonGroup btnGrupInquilinos;
    private javax.swing.JButton btnLimpiarBuscarInmueble;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelInicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JLabel lblContratosVigentes;
    private javax.swing.JLabel lblTotalInmueble;
    private javax.swing.JLabel lblTotalInquilinos;
    private javax.swing.JLabel lblTotalPropietario;
    private javax.swing.JRadioButton rbtnInmueblesAlquilados;
    private javax.swing.JRadioButton rbtnInmueblesLibres;
    private javax.swing.JRadioButton rbtnInmueblesTodos;
    private javax.swing.JRadioButton rbtnInquilinoActivos;
    private javax.swing.JRadioButton rbtnInquilinoInactivos;
    private javax.swing.JRadioButton rbtnInquilinoTodos;
    private javax.swing.JRadioButton rbtnPropietarioTodos;
    private javax.swing.JComboBox<String> selectBuscarInmueble;
    private javax.swing.JTable tablaContratos;
    private javax.swing.JTable tablaInmuebles;
    private javax.swing.JTable tablaInquilinos;
    private javax.swing.JTable tablaPropietarios;
    private javax.swing.JTextField txfBuscarInmueble;
    private javax.swing.JTextField txfBuscarInquilino;
    // End of variables declaration//GEN-END:variables
}
