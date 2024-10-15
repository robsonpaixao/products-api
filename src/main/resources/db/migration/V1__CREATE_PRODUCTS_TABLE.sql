CREATE TABLE products (
    id SERIAL PRIMARY KEY, -- Identificador único do produto
    name VARCHAR(255) NOT NULL, -- Nome do produto
    description TEXT, -- Descrição detalhada do produto
    price DECIMAL(10, 2) NOT NULL, -- Preço do produto, com 2 casas decimais
    sku VARCHAR(100) UNIQUE, -- Código SKU (Stock Keeping Unit), identificador único de estoque
    quantity_in_stock INT DEFAULT 0, -- Quantidade em estoque
    dimensions VARCHAR(100), -- Dimensões do produto (por exemplo, "10x20x30 cm")
    is_active BOOLEAN DEFAULT TRUE, -- Indica se o produto está ativo ou inativo
    created_at TIMESTAMP DEFAULT NOW(), -- Data e hora de criação
    updated_at TIMESTAMP DEFAULT NOW(), -- Data e hora de última atualização
    CONSTRAINT chk_price CHECK (price >= 0), -- Verificação para garantir que o preço não seja negativo
    CONSTRAINT chk_quantity CHECK (quantity_in_stock >= 0) -- Verificação para garantir que o estoque não seja negativo
);