SELECT temporal from cr_address_person ap
INNER JOIN cr_person p ON p.person_id = ap.person_id
INNER JOIN cr_address a ON a.address_id = ap.address_id
WHERE
UPPER (p.sur_name) = UPPER (?)
AND UPPER (p.given_name) = UPPER (?)
AND UPPER (patronymic) = UPPER(?)
AND p.date_of_birth = ?
AND a.street_code = ?
AND UPPER (a.building) = UPPER(?)
AND UPPER (extension) = UPPER(?)
AND UPPER (apartment) = UPPER(?);