CREATE TABLE IF NOT EXISTS Product(
          id                varchar      (6)               NOT NULL  PRIMARY KEY
         ,name              varchar      (32)              NOT NULL
         ,amount            int          (5)    Default 0  NOT NULL
         ,salesAvailability varchar      (1)    Default 0  NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS Stock(
          id                varchar      (6)              NOT NULL  PRIMARY KEY
         ,productId         varchar      (6)              NOT NULL
         ,quantity          int          (2)   Default 0  NOT NULL
         ,replenishmentTime timestamp                     NOT NULL
         ,CONSTRAINT fk_stock_productId
         	FOREIGN KEY (productId)
         	REFERENCES Product (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS SalesHistory(
          id                varchar      (6)              NOT NULL  PRIMARY KEY
         ,productId         varchar      (6)              NOT NULL
         ,amount            int          (5)   Default 0  NOT NULL
         ,time              timestamp                     NOT NULL
         ,CONSTRAINT fk_salesHistory_productId
         	FOREIGN KEY (productId)
         	REFERENCES Product (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;