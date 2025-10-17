-- Armar aquí la base de datos

DELETE FROM routes;

-- Ruta 1: Ruta del Cares (de Wikiloc/Turismo Asturias)
INSERT INTO routes (name, area, kilometres, difficulty, description) VALUES 
('Ruta del Cares', 'Picos de Europa', 12, 'Moderada', 'Sendero icónico por el desfiladero del río Cares, con puentes y vistas espectaculares. Tiempo estimado: 4-6 horas. Ideal para intermedios.');

-- Ruta 2: Desfiladero de Las Xanas
INSERT INTO routes (name, area, kilometres, difficulty, description) VALUES 
('Desfiladero de Las Xanas', 'Centro de Asturias', 8, 'Fácil', 'Ruta accesible con túneles y cascadas. Tiempo: 3 horas. Perfecta para familias.');

-- Ruta 3: Senda del Oso (agrega más imitando este formato)
INSERT INTO routes (name, area, kilometres, difficulty, description) VALUES 
('Senda del Oso', 'Teverga', 20, 'Fácil-Moderada', 'Camino por valles verdes, posible avistamiento de osos. Tiempo: 5 horas. Buena para bici o pie.');