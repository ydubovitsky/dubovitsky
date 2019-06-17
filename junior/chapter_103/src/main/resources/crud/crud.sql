CREATE database job4j_postgres;

CREATE TABLE "Users" (
	"id_user" serial NOT NULL,
	"name" integer(30) NOT NULL UNIQUE,
	"password" integer(30) NOT NULL,
	"id_role" integer(30) NOT NULL,
	"email" VARCHAR(50) NOT NULL,
	CONSTRAINT "Users_pk" PRIMARY KEY ("id_user")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Role" (
	"id_role" serial NOT NULL,
	"role" TEXT NOT NULL,
	"id_rules" integer NOT NULL,
	CONSTRAINT "Role_pk" PRIMARY KEY ("id_role")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Rules" (
	"id_rules" serial NOT NULL,
	"rule" TEXT NOT NULL,
	"description" TEXT,
	CONSTRAINT "Rules_pk" PRIMARY KEY ("id_rules")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Items" (
	"id_item" serial NOT NULL,
	"description" serial NOT NULL,
	"id_user" serial NOT NULL,
	CONSTRAINT "Items_pk" PRIMARY KEY ("id_item")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Comments" (
	"id_comments" serial NOT NULL,
	"text" TEXT NOT NULL,
	"id_items" integer NOT NULL,
	CONSTRAINT "Comments_pk" PRIMARY KEY ("id_comments")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Attachs" (
	"id_attach" BINARY NOT NULL,
	"file" BINARY NOT NULL,
	"id_item" BINARY NOT NULL,
	CONSTRAINT "Attachs_pk" PRIMARY KEY ("id_attach")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "State" (
	"id_state" serial NOT NULL,
	"description" TEXT,
	"id_item" integer,
	CONSTRAINT "State_pk" PRIMARY KEY ("id_state")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Category" (
	"id_category" serial NOT NULL,
	"category" serial NOT NULL,
	"id_item" integer NOT NULL,
	CONSTRAINT "Category_pk" PRIMARY KEY ("id_category")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "Users" ADD CONSTRAINT "Users_fk0" FOREIGN KEY ("id_role") REFERENCES "Role"("id_role");

ALTER TABLE "Role" ADD CONSTRAINT "Role_fk0" FOREIGN KEY ("role") REFERENCES ""("");
ALTER TABLE "Role" ADD CONSTRAINT "Role_fk1" FOREIGN KEY ("id_rules") REFERENCES "Rules"("id_rules");


ALTER TABLE "Items" ADD CONSTRAINT "Items_fk0" FOREIGN KEY ("id_user") REFERENCES "Users"("id_user");

ALTER TABLE "Comments" ADD CONSTRAINT "Comments_fk0" FOREIGN KEY ("id_items") REFERENCES "Items"("id_item");

ALTER TABLE "Attachs" ADD CONSTRAINT "Attachs_fk0" FOREIGN KEY ("id_item") REFERENCES "Items"("id_item");

ALTER TABLE "State" ADD CONSTRAINT "State_fk0" FOREIGN KEY ("id_item") REFERENCES "Items"("id_item");

ALTER TABLE "Category" ADD CONSTRAINT "Category_fk0" FOREIGN KEY ("id_item") REFERENCES "Items"("id_item");
