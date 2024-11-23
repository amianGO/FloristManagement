
INSERT INTO Proveedores (Nombre, Nit, Empresa, Contacto, Direccion) VALUES
('Juan Pérez', 123456789, 'Flores del Sol', 5551234, 'Calle 1 #10-20'),
('Ana Gómez', 987654321, 'Orquídeas Hermosas', 5555678, 'Carrera 15 #20-30'),
('Carlos López', 456789123, 'Rosas y Más', 5557890, 'Avenida 45 #50-60');

INSERT INTO Inventario_Floral (Tipo, Color, Variedad, Stock, Precio_Venta, Precio_Compra, Fecha_Ingreso, Ubicacion, Id_Proveedor) VALUES
('Rosa', 'Rojo', 'Premium', 100, 5000, 3000, '2024-11-01 10:00:00', 'Almacén A1', 1),
('Orquídea', 'Blanco', 'Phalaenopsis', 50, 15000, 10000, '2024-11-05 12:00:00', 'Almacén B2', 2),
('Clavel', 'Rosado', 'Estándar', 200, 2000, 1000, '2024-11-10 14:00:00', 'Almacén C3', 3),
('Lirio', 'Amarillo', 'Oriental', 75, 8000, 5000, '2024-11-15 16:00:00', 'Almacén D4', 1);