-- ==============================================
-- 🌿 Asturias Ruta & Ride - Rutas de ejemplo
-- ==============================================

-- Limpiar la tabla antes de insertar (opcional durante desarrollo)
DELETE FROM routes;

-- Insertar rutas de ejemplo
INSERT INTO routes (name, area, kilometres, difficulty, description)
VALUES
('Ruta del Cares', 'Picos de Europa', 12, 'Media', 
 'Una de las rutas más emblemáticas de Asturias. Atraviesa un impresionante desfiladero entre Caín y Poncebos con vistas espectaculares.'),
('Lagos de Covadonga', 'Cangas de Onís', 6, 'Fácil', 
 'Recorrido circular que une los lagos Enol y Ercina, rodeados de montañas y praderas asturianas. Ideal para familias.'),
('Senda del Oso', 'Proaza', 22, 'Fácil', 
 'Vía verde que recorre antiguos trazados mineros. Perfecta para caminar o ir en bicicleta. Popular por su paisaje y túneles.'),
('Ruta de las Xanas', 'Santo Adriano', 8, 'Media', 
 'Sendero que atraviesa un desfiladero espectacular con pasarelas sobre el río. Ruta corta pero con cierto desnivel.'),
('Bosque de Peloño', 'Ponga', 13, 'Moderada', 
 'Ruta circular por uno de los hayedos más bellos de Asturias. Ideal en otoño por el colorido de las hojas.'),
('Mirador del Fitu', 'Arriondas', 10, 'Fácil', 
 'Camino corto y panorámico que lleva hasta el mirador del Fitu, con vistas sobre la costa y los Picos de Europa.');