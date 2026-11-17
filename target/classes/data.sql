INSERT INTO sample_data (name)
SELECT 'Harsha'
WHERE NOT EXISTS (SELECT 1 FROM sample_data WHERE name = 'Harsha');

INSERT INTO sample_data (name)
SELECT 'Sai'
WHERE NOT EXISTS (SELECT 1 FROM sample_data WHERE name = 'Sai');
