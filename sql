INSERT INTO public.roles(
	id, name)
	VALUES (1, 'ROLE_ADMIN'),
	(2, 'ROLE_CLIENT');

INSERT INTO public.clients(
	id, adress, birth_date, email, first_name, last_name, passport, password)
	VALUES (1,
			'Sochi',
			'1952-10-07',
			'vladimir@putin.ru',
			'Vladimir',
			'Putin',
			'0123 456789',
			'$2a$10$CLJcFd9l9M2nP02DaT8zCOpIfMnVq5QRIqIJZxhCuB4UF7dC15MQG');

INSERT INTO public.clients_roles(
	client_id, role_id)
	VALUES (1, 1),
	(1, 2);
