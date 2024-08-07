-- 코드를 입력하세요
# SELECT * FROM ANIMAL_INS;
# SELECT AI.ANIMAL_ID, AI.NAME
# FROM ANIMAL_INS AS AI
# LEFT JOIN ANIMAL_OUTS AS AO
# ON AI.ANIMAL_ID = AO.ANIMAL_ID
# WHERE AO.DATETIME < AI.DATETIME
# ORDER BY AI.DATETIME;

SELECT ANIMAL_INS.ANIMAL_ID, ANIMAL_INS.NAME
FROM ANIMAL_INS
LEFT JOIN ANIMAL_OUTS
ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
WHERE ANIMAL_INS.DATETIME > ANIMAL_OUTS.DATETIME
ORDER BY ANIMAL_INS.DATETIME;