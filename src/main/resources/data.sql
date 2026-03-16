-- 1. Inserindo Usuários (tsec_users)
-- Como o ID é auto-incremento, o banco vai gerar os IDs 1, 2 e 3 para estes registros.
INSERT INTO tsec_users (nome_usuario, email_usuario, password_usuario) 
VALUES ('Desenvolvedor Backend', 'backend@email.com', '$2a$10$HashExemploSenha123');

INSERT INTO tsec_users (nome_usuario, email_usuario, password_usuario) 
VALUES ('Desenvolvedor Frontend', 'frontend@email.com', '$2a$10$HashExemploSenha456');

INSERT INTO tsec_users (nome_usuario, email_usuario, password_usuario) 
VALUES ('Tech Lead', 'techlead@email.com', '$2a$10$HashExemploSenha789');


-- 2. Inserindo Matérias (tsec_materias)
-- Relacionando com os IDs dos usuários criados acima.
INSERT INTO tsec_materias (nome_materia, id_usuario) 
VALUES ('Java e Spring Boot', 1);

INSERT INTO tsec_materias (nome_materia, id_usuario) 
VALUES ('React e Ecossistema', 2);

INSERT INTO tsec_materias (nome_materia, id_usuario) 
VALUES ('Professional English', 3);


-- 3. Inserindo Assuntos (tsec_assuntos)
-- Relacionando com os IDs das matérias criadas acima.
INSERT INTO tsec_assuntos (nome_assunto, id_materia) 
VALUES ('Mapeamento JPA e Hibernate', 1);

INSERT INTO tsec_assuntos (nome_assunto, id_materia) 
VALUES ('Gerenciamento de Estado e Hooks', 2);

INSERT INTO tsec_assuntos (nome_assunto, id_materia) 
VALUES ('Job Interview Vocabulary', 3);


-- 4. Inserindo Questões (tsec_questoes)
-- Relacionando com assuntos, matérias e usuários. 
-- Nota: Usamos CURRENT_TIMESTAMP para preencher a data_registro via banco de dados.
INSERT INTO tsec_questoes (qtd_questoes, qtd_acertos, qtd_erros, id_assunto, id_materia, id_usuario, data_registro) 
VALUES (20, 15, 5, 1, 1, 1, CURRENT_TIMESTAMP);

INSERT INTO tsec_questoes (qtd_questoes, qtd_acertos, qtd_erros, id_assunto, id_materia, id_usuario, data_registro) 
VALUES (15, 12, 3, 2, 2, 2, CURRENT_TIMESTAMP);

INSERT INTO tsec_questoes (qtd_questoes, qtd_acertos, qtd_erros, id_assunto, id_materia, id_usuario, data_registro) 
VALUES (10, 9, 1, 3, 3, 3, CURRENT_TIMESTAMP);


-- 5. Inserindo Tempos de Estudo (tsec_tempos)
-- Relacionando com assuntos e matérias.
INSERT INTO tsec_tempos (tempo_estudo, id_assunto, id_materia, data_registro) 
VALUES (120, 1, 1, CURRENT_TIMESTAMP);

INSERT INTO tsec_tempos (tempo_estudo, id_assunto, id_materia, data_registro) 
VALUES (90, 2, 2, CURRENT_TIMESTAMP);

INSERT INTO tsec_tempos (tempo_estudo, id_assunto, id_materia, data_registro) 
VALUES (45, 3, 3, CURRENT_TIMESTAMP);