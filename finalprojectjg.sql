--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.0
-- Dumped by pg_dump version 9.5.0

-- Started on 2016-04-11 04:07:05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;


--
-- TOC entry 190 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 190
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 180 (class 1259 OID 41528)
-- Name: animal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE animal (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    speciesid integer,
    enclosureid integer
);


ALTER TABLE animal OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 41531)
-- Name: animal_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animal_id_seq OWNER TO postgres;

--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 181
-- Name: animal_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE animal_id_seq OWNED BY animal.id;


--
-- TOC entry 182 (class 1259 OID 41533)
-- Name: enclosure; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE enclosure (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    animaltotal integer NOT NULL,
    condition character varying(50) NOT NULL,
    startfeedtime timestamp without time zone NOT NULL,
    endfeedtime timestamp without time zone NOT NULL
);


ALTER TABLE enclosure OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 41536)
-- Name: enclosure_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE enclosure_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE enclosure_id_seq OWNER TO postgres;

--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 183
-- Name: enclosure_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE enclosure_id_seq OWNED BY enclosure.id;


--
-- TOC entry 184 (class 1259 OID 41538)
-- Name: food; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE food (
    id integer NOT NULL,
    vendor character varying(50) NOT NULL,
    foodcategoryid integer,
    name character varying(50) NOT NULL
);


ALTER TABLE food OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 41541)
-- Name: food_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE food_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE food_id_seq OWNER TO postgres;

--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 185
-- Name: food_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE food_id_seq OWNED BY food.id;


--
-- TOC entry 186 (class 1259 OID 41543)
-- Name: foodcategory; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE foodcategory (
    id integer NOT NULL,
    categoryname character varying(50) NOT NULL
);


ALTER TABLE foodcategory OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 41546)
-- Name: foodcategory_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE foodcategory_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE foodcategory_id_seq OWNER TO postgres;

--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 187
-- Name: foodcategory_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE foodcategory_id_seq OWNED BY foodcategory.id;


--
-- TOC entry 188 (class 1259 OID 41548)
-- Name: species; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE species (
    id integer NOT NULL,
    commonname character varying(50) NOT NULL,
    scientificname character varying(50) NOT NULL,
    infolink character varying(100) NOT NULL,
    foodid integer
);


ALTER TABLE species OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 41551)
-- Name: species_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE species_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE species_id_seq OWNER TO postgres;

--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 189
-- Name: species_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE species_id_seq OWNED BY species.id;


--
-- TOC entry 2005 (class 2604 OID 41553)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY animal ALTER COLUMN id SET DEFAULT nextval('animal_id_seq'::regclass);


--
-- TOC entry 2006 (class 2604 OID 41554)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY enclosure ALTER COLUMN id SET DEFAULT nextval('enclosure_id_seq'::regclass);


--
-- TOC entry 2007 (class 2604 OID 41555)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY food ALTER COLUMN id SET DEFAULT nextval('food_id_seq'::regclass);


--
-- TOC entry 2008 (class 2604 OID 41556)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY foodcategory ALTER COLUMN id SET DEFAULT nextval('foodcategory_id_seq'::regclass);


--
-- TOC entry 2009 (class 2604 OID 41557)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY species ALTER COLUMN id SET DEFAULT nextval('species_id_seq'::regclass);


--
-- TOC entry 2144 (class 0 OID 41528)
-- Dependencies: 180
-- Data for Name: animal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO animal VALUES (10, 'momo', 4, 17);
INSERT INTO animal VALUES (1, 'Happy', 4, 8);
INSERT INTO animal VALUES (8, 'Dori', 4, 17);
INSERT INTO animal VALUES (6, 'snoopy', 14, 8);
INSERT INTO animal VALUES (9, 'snipe', 1, 8);
INSERT INTO animal VALUES (5, 'chowchow', 12, 15);
INSERT INTO animal VALUES (4, 'King', 11, 16);
INSERT INTO animal VALUES (3, 'Chewy', 8, 18);
INSERT INTO animal VALUES (2, 'Coco', 2, 13);
INSERT INTO animal VALUES (14, 'Lucy', 1, 13);
INSERT INTO animal VALUES (7, 'garfield', 10, 16);
INSERT INTO animal VALUES (60, 'Snowball', 12, 15);


--
-- TOC entry 2167 (class 0 OID 0)
-- Dependencies: 181
-- Name: animal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('animal_id_seq', 60, true);


--
-- TOC entry 2146 (class 0 OID 41533)
-- Dependencies: 182
-- Data for Name: enclosure; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO enclosure VALUES (17, 'Small mammal house', 2, 'small', '2016-04-11 08:00:00.13', '2016-04-11 00:00:00.155');
INSERT INTO enclosure VALUES (13, 'Amazon', 2, 'Hot', '2016-04-08 07:01:51.803', '2016-04-08 09:01:51.83');
INSERT INTO enclosure VALUES (18, 'Ice land', 1, 'cold', '2016-04-11 09:00:00.13', '2016-04-11 18:00:00.155');
INSERT INTO enclosure VALUES (8, 'Happy zone', 3, 'Good', '2016-04-05 16:08:37.53', '2016-04-05 18:08:37.53');
INSERT INTO enclosure VALUES (16, 'Bird House', 2, 'Flying', '2016-04-11 05:00:23.81', '2016-04-11 07:00:23.839');
INSERT INTO enclosure VALUES (15, 'Giant Panda Habitat', 2, 'Warm', '2016-04-11 07:00:23.81', '2016-04-11 09:00:23.839');


--
-- TOC entry 2168 (class 0 OID 0)
-- Dependencies: 183
-- Name: enclosure_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('enclosure_id_seq', 18, true);


--
-- TOC entry 2148 (class 0 OID 41538)
-- Dependencies: 184
-- Data for Name: food; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO food VALUES (2, 'Randy''s meat', 3, 'Beef');
INSERT INTO food VALUES (1, 'Big''Y', 2, 'Banana');
INSERT INTO food VALUES (3, 'Farm house', 1, 'Milk');
INSERT INTO food VALUES (10, 'Wegmans', 4, 'Carrot');
INSERT INTO food VALUES (4, 'Wegmans', 2, 'Peach');
INSERT INTO food VALUES (8, 'Randy''s meat', 3, 'Pork');
INSERT INTO food VALUES (17, 'Wegmans', 4, 'Celery');
INSERT INTO food VALUES (18, 'Big''Y', 1, 'cheese');
INSERT INTO food VALUES (19, 'Chocolate shop', 5, 'Chocolate');
INSERT INTO food VALUES (20, 'Bamboo farm', 4, 'Bamboo');
INSERT INTO food VALUES (21, 'Annapolis Ice Cream Company', 1, 'ice cream');
INSERT INTO food VALUES (22, 'Randy''s meat', 3, 'Meatballs');


--
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 185
-- Name: food_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('food_id_seq', 22, true);


--
-- TOC entry 2150 (class 0 OID 41543)
-- Dependencies: 186
-- Data for Name: foodcategory; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO foodcategory VALUES (1, 'Dairy');
INSERT INTO foodcategory VALUES (2, 'Fruit');
INSERT INTO foodcategory VALUES (3, 'Meat');
INSERT INTO foodcategory VALUES (4, 'Vegetable');
INSERT INTO foodcategory VALUES (5, 'Other');


--
-- TOC entry 2170 (class 0 OID 0)
-- Dependencies: 187
-- Name: foodcategory_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('foodcategory_id_seq', 1, false);


--
-- TOC entry 2152 (class 0 OID 41548)
-- Dependencies: 188
-- Data for Name: species; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO species VALUES (1, 'Tiger', 'Panthera Tigris', 'http://a-z-animals.com/animals/tiger/', 3);
INSERT INTO species VALUES (2, 'Sea Lion', 'Otariidae', 'http://a-z-animals.com/animals/sea-lion/', 2);
INSERT INTO species VALUES (4, 'Dog', 'Canis lupus familiaris', 'https://en.wikipedia.org/wiki/Dog', 2);
INSERT INTO species VALUES (7, 'Great White Shark', 'Carcharodon carcharias', 'https://www.worldwildlife.org/species/great-white-shark', 22);
INSERT INTO species VALUES (8, 'Polar Bear', 'Ursus maritimus', 'https://www.worldwildlife.org/species/polar-bear', 21);
INSERT INTO species VALUES (9, 'White Rhino', 'Ceratotherium simum', 'https://www.worldwildlife.org/species/white-rhino', 18);
INSERT INTO species VALUES (10, 'Bald Eagle', 'leucocephalus', 'http://animals.sandiegozoo.org/animals/bald-eagle', 17);
INSERT INTO species VALUES (11, 'Ostrich', 'Struthio Camelus', 'http://a-z-animals.com/animals/ostrich/', 19);
INSERT INTO species VALUES (12, 'Panda', 'Ailuropoda melanoleuca', 'http://a-z-animals.com/animals/giant-panda-bear/', 20);
INSERT INTO species VALUES (13, 'Goose', 'Branta', 'http://a-z-animals.com/animals/goose/', 10);
INSERT INTO species VALUES (14, 'Elephant', 'Loxodonta Africana', 'http://a-z-animals.com/animals/elephant/', 4);


--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 189
-- Name: species_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('species_id_seq', 14, true);


--
-- TOC entry 2011 (class 2606 OID 41559)
-- Name: animal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY (id);


--
-- TOC entry 2013 (class 2606 OID 41561)
-- Name: enclosure_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY enclosure
    ADD CONSTRAINT enclosure_pkey PRIMARY KEY (id);


--
-- TOC entry 2015 (class 2606 OID 41605)
-- Name: food_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY food
    ADD CONSTRAINT food_name_key UNIQUE (name);


--
-- TOC entry 2017 (class 2606 OID 41563)
-- Name: food_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY food
    ADD CONSTRAINT food_pkey PRIMARY KEY (id);


--
-- TOC entry 2019 (class 2606 OID 41565)
-- Name: foodcategory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY foodcategory
    ADD CONSTRAINT foodcategory_pkey PRIMARY KEY (id);


--
-- TOC entry 2021 (class 2606 OID 41567)
-- Name: species_commonname_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY species
    ADD CONSTRAINT species_commonname_key UNIQUE (commonname);


--
-- TOC entry 2023 (class 2606 OID 41569)
-- Name: species_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY species
    ADD CONSTRAINT species_pkey PRIMARY KEY (id);


--
-- TOC entry 2025 (class 2606 OID 41571)
-- Name: species_scientificname_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY species
    ADD CONSTRAINT species_scientificname_key UNIQUE (scientificname);


--
-- TOC entry 2026 (class 2606 OID 41572)
-- Name: animal_enclosureid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY animal
    ADD CONSTRAINT animal_enclosureid_fkey FOREIGN KEY (enclosureid) REFERENCES enclosure(id);


--
-- TOC entry 2027 (class 2606 OID 41577)
-- Name: animal_speciesid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY animal
    ADD CONSTRAINT animal_speciesid_fkey FOREIGN KEY (speciesid) REFERENCES species(id);


--
-- TOC entry 2028 (class 2606 OID 41582)
-- Name: food_foodcategoryid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY food
    ADD CONSTRAINT food_foodcategoryid_fkey FOREIGN KEY (foodcategoryid) REFERENCES foodcategory(id);


--
-- TOC entry 2029 (class 2606 OID 41587)
-- Name: species_foodid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY species
    ADD CONSTRAINT species_foodid_fkey FOREIGN KEY (foodid) REFERENCES food(id);


--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-11 04:07:06

--
-- PostgreSQL database dump complete
--

