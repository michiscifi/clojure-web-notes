SELECT *
FROM note
WHERE content LIKE :term
ORDER BY content ASC;