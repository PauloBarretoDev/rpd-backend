# Raccon City Police Department - BackEnd

## Atividade Final AOS - Raccon Police Department - SpringBoot

### Link para a publicação:

<a href="https://rpd-backend.onrender.com/agents/list">Publicação</a>

### Projeto em Spring Boot com a ideia de ser uma delegacia de polícia baseado no jogo Resident Evil.

# Rotas

### Todas as rotas seguem o mesmo padrão, tendo o nome da classe no plural e em seguida o que cada rota faz.

#### Rotas para Agents
- `GET` /agents/list
- `POST` /agents/register
- `GET` /agents/agent/key={id}
- `PUT` /agents/update/agent/key={id}
- `DELETE` /agents/delete/agent/key={id}

#### Rotas para Address
- `GET` /addresses/list
- `POST` /addresses/register
- `GET` /addresses/address/key={id}
- `PUT` /addresses/update/address/key={id}
- `DELETE` /addresses/delete/address/key={id}

#### Rotas para Phone
- `GET` /phones/list
- `POST` /phones/register
- `GET` /phones/phone/key={id}
- `PUT` /phones/update/phone/key={id}
- `DELETE` /phones/delete/phone/key={id}

#### Rotas para Role
- `GET` /roles/list
- `POST` /roles/register
- `GET` /roles/role/key={id}
- `PUT` /roles/update/role/key={id}
- `DELETE` /roles/delete/role/key={id}

#### Rotas para Mission
- `GET` /missions/list
- `POST` /missions/register
- `GET` /missions/mission/key={id}
- `PUT` /missions/update/mission/key={id}
- `DELETE` /missions/delete/mission/key={id}

#### Rotas para Incident Report
- `GET` /incidents/list
- `POST` /incidents/register
- `GET` /incidents/incident/key={id}
- `PUT` /incidents/update/incident/key={id}
- `DELETE` /incidents/delete/incident/key={id}

#### Rotas para Biological Weapons
- `GET` /biologicalWeapons/list
- `POST` /biologicalWeapons/register
- `GET` /biologicalWeapons/bioWeapon/key={id}
- `PUT` /biologicalWeapons/update/bioWeapon/key={id}
- `DELETE` /biologicalWeapons/delete/bioWeapon/key={id}

#### Rotas para Biological Weapons Types
- `GET` /bioWeaponTypes/list
- `POST` /bioWeaponTypes/register
- `GET` /bioWeaponTypes/bioWeaponType/key={id}
- `PUT` /bioWeaponTypes/update/bioWeaponType/key={id}
- `DELETE` /bioWeaponTypes/delete/bioWeaponType/key={id}

