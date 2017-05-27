# Fantasy Simulator

Fantasy harc szimulátor, amelyben 2 játékos különböző fajokból választhat és előre meghatározott jártasság pontokat oszthat szét a   karakter 2 fő tulajdonsága között, amelyek különböző kihatással vannak a tulajdonságaikra. A harc menete körökre osztott és valamely játékos „haláláig” tart.

Új játék során a játékosoknak kötelezően meg kell adniuk a karakterek nevét, faját, illetve ki kell osztaniuk 10 jártasság pontot az Ügyesség és a Erő között. Ezek értéke fajonként különböző képpen hatással van az Életerőre, Mozgáspontra, Támadó értékre és a Védő értékre.

### Fajok szerinti Mozgáspont számolás
| Faj | Ügyesség szorzat |
| ----|:--------:|
| Elf | 2 |
| Ork | 1.2 |
| Gnóm | 1.1 |
| Törpe | 1.3 |
| Ember | 1.5 |
| Félszerzet | 1.6 |

### Fajok szerinti Életerő számolás
| Faj | Erő szorzat |
| ----|:--------:|
| Elf | 7 |
| Ork | 11 |
| Gnóm | 12 |
| Törpe | 10 |
| Ember | 9 |
| Félszerzet | 8 |

### Játék menete

A játék/harc menete körökosztott. A játékosok sorrendje a karakterek mozgáspontjától függ. A "Dobás" gomb egy 2 db 10 oldalú kocka eldobását szimulálja. Ha a dobott érték a Találati értékkel megegyezik vagy az alá esik, akkor a dobó játékos eltalálta az ellenfelét és ilyenkor a dobó játékos Támadó értékével csökken az ellenfél Életereje. Ha a dobott érték megegyezik vagy az alá esik a Kritikus találati értéknek, akkor egyazon körönbelül újra levonásra kerül az ellenfél Életerejéből a dobó játékos Támadó értéke. Egy játékmenet valamely játékos haláláig, vagyis amíg valamely játkos Életereje 0 vagy az alá nem esik.

