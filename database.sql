CREATE TABLE IF NOT EXISTS instituicao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipo VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS evento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_inicial DATE NOT NULL,
    data_final DATE NOT NULL,
    ativo BOOLEAN NOT NULL,
    instituicao_id INT NOT NULL,
    CONSTRAINT fk_evento_instituicao
      FOREIGN KEY (instituicao_id) REFERENCES instituicao(id)
);