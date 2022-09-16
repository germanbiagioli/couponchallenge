INSERT INTO items VALUES ('MLA1',30,2000.00);
INSERT INTO items VALUES ('MLA2',21,100.50); 
INSERT INTO items VALUES ('MLA3',19,90.9); 
INSERT INTO items VALUES ('MLA4',32,67.15); 
INSERT INTO items VALUES ('MLA5',23,59.45); 
INSERT INTO items VALUES ('MLA6',80,45.00); 
INSERT INTO items VALUES ('MLA7',15,1342.00); 
INSERT INTO items VALUES ('MLA8',28,150.80); 
INSERT INTO items VALUES ('MLA9',27,200.00);
INSERT INTO items VALUES ('MLA10',11,180.10);


INSERT INTO users (username, password, enabled) VALUES
          ('gustavo.fiasche', '$2a$10$FG22DSjkkz4cDY/b04I2F.vq/Anux2vlqFOHXkm0YdXZwYQHn/toi', true);
          
 INSERT INTO roles (name) VALUES
          ('USER'),
          ('ADMIN'),
          ('MANAGER');
          
INSERT INTO users_roles (user_id, role_id) VALUES
          (1, 1);