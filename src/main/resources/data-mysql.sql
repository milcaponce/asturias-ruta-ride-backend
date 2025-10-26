-- ==============================================
-- 🌿 Asturias Ruta & Ride - Rutas de ejemplo
-- ==============================================


DELETE FROM routes;

-- Ruta 1: Ruta del Cares 
INSERT INTO routes (name, area, kilometres, difficulty, image, description, latitude, longitude) VALUES 
('Ruta del Cares', 'Picos de Europa', 12, 'Moderada', 'ruta-del-cares.jpg', 'Sendero icónico por el desfiladero del río Cares, con vistas a acantilados y montañas. En 2025, agregaron puentes accesibles. Tiempo ~4-6 horas. Ideal para intermedios.', 43.25557238001706, -4.835785794076657);

-- Ruta 2: Desfiladero de Las Xanas 
INSERT INTO routes (name, area, kilometres, difficulty, image, description, latitude, longitude) VALUES 
('Desfiladero de Las Xanas', 'Centro de Asturias', 8, 'Fácil', 'desfiladero-de-las-xanas.jpg', 'Ruta accesible con túneles, puentes y cascadas. En 2025, eventos de birdwatching. Tiempo ~3 horas. Perfecta para familias.', 43.27679096962386, -5.990495655610837);

-- Ruta 3: Senda del Oso 
INSERT INTO routes (name, area, kilometres, difficulty, image, description, latitude, longitude) VALUES 
('Senda del Oso', 'Teverga', 20, 'Fácil-Moderada', 'senda-del-oso.jpg', 'Camino por valles verdes con posible avistamiento de osos. En 2025, ampliaron para bici. Tiempo ~5-6 horas.', 43.21355657157283, -6.036588382902724);

-- Ruta 4: Acantilados de Pimiango 
INSERT INTO routes (name, area, kilometres, difficulty, image, description, latitude, longitude) VALUES 
('Acantilados de Pimiango', 'Oriente', 10, 'Moderada', 'acantilados-de-pimiango.jpg', 'Vistas al mar Cantábrico y playas salvajes. En 2025, proyectos eco. Tiempo ~4 horas.', 43.39778288556528, -4.531848384659271);

-- Ruta 5: Bosque de Peloño 
INSERT INTO routes (name, area, kilometres, difficulty, image, description, latitude, longitude) VALUES 
('Bosque de Peloño', 'Suroccidente', 15, 'Difícil', 'bosque-de-peloño.jpg', 'Robles centenarios y biodiversidad. Requiere permiso; en 2025, tours guiados. Tiempo ~6 horas.', 43.18632250944198, -5.1416107288351816);

-- Ruta 6: Cabo Busto 
INSERT INTO routes (name, area, kilometres, difficulty, image, description, latitude, longitude) VALUES 
('Cabo Busto', 'Occidente', 7, 'Fácil', 'ruta-cabo-busto.jpg', 'Paseo costero con acantilados. En 2025, nuevos miradores. Tiempo ~2-3 horas.', 43.56968513696994, -6.469666710666092);

-- Ruta 7: Senda Costera de los Miradores 
INSERT INTO routes (name, area, kilometres, difficulty, image, description, latitude, longitude) VALUES 
('Senda Costera de los Miradores', 'Muros de Nalón', 10, 'Moderada', 'senda-de-los-miradores.jpg', 'Vistas panorámicas a acantilados. Tiempo ~3-4 horas. Ideal para fotos.', 43.559998400910196, -6.087453512535582);

-- Ruta 8: Cascadas de Oneta 
INSERT INTO routes (name, area, kilometres, difficulty, image, description, latitude, longitude) VALUES 
('Cascadas de Oneta', 'Occidente', 5, 'Fácil', 'cascadas-de-oneta.jpg', 'Tres cascadas en selva cantábrica. En 2025, accesos mejorados. Tiempo ~2 horas.', 43.464641989610634, -6.667702980697273);

-- Ruta 9: Tabayón de Mongayo 
INSERT INTO routes (name, area, kilometres, difficulty, image, description, latitude, longitude) VALUES 
('Tabayón de Mongayo', 'Oriente', 10, 'Moderada', 'tabayon-de-mongayo.jpg', 'Cascada en bosque exuberante. Tiempo ~4 horas. Biodiversidad única.', 43.106589822937494, -5.2599443171870055);

-- Ruta 10: Hoces del Esva 
INSERT INTO routes (name, area, kilometres, difficulty, image, description, latitude, longitude) VALUES 
('Hoces del Esva', 'Occidente', 12, 'Moderada', 'hoces-del-esva.jpg', 'Ruta por río con hoces y vegetación. Tiempo ~4-5 horas. Aventura natural.', 43.45771278184274, -6.4849424423296345);