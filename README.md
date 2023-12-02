# Raccon City Police Department - BackEnd

## Atividade Final AOS - Raccon Police Department - SpringBoot

### Link para a publicação:

<a href="https://rpd-backend.onrender.com/agents/list">Publicação</a>

### Projeto em Spring Boot com a ideia de ser uma delegacia de polícia baseado no jogo Resident Evil.

# Rotas

### Todas as rotas seguem o mesmo padrão, tendo o nome da classe no plural e em seguida o que cada rota faz.

#### Rotas para Agents
<ul>
  <li>/agents/list</li>
  <li>/agents/register</li>
  <li>/agents/agent/key={id}</li>
  <li>/agents/update/agent/key={id}</li>
  <li>/agents/delete/agent/key={id}</li>
</ul>

#### Rotas para Address
<ul>
  <li>/addresses/list</li>
  <li>/addresses/register</li>
  <li>/addresses/address/key={id}</li>
  <li>/addresses/update/address/key={id}</li>
  <li>/addresses/delete/address/key={id}</li>
</ul>

#### Rotas para Phone
<ul>
  <li>/phones/list</li>
  <li>/phones/register</li>
  <li>/phones/phone/key={id}</li>
  <li>/phones/update/phone/key={id}</li>
  <li>/phones/delete/phone/key={id}</li>
</ul>

#### Rotas para Role
<ul>
  <li>/roles/list</li>
  <li>/roles/register</li>
  <li>/roles/role/key={id}</li>
  <li>/roles/update/role/key={id}</li>
  <li>/roles/delete/role/key={id}</li>
</ul>

#### Rotas para Mission
<ul>
  <li>/missions/list</li>
  <li>/missions/register</li>
  <li>/missions/mission/key={id}</li>
  <li>/missions/update/mission/key={id}</li>
  <li>/missions/delete/mission/key={id}</li>
</ul>

#### Rotas para Incident Report
<ul>
  <li>/incidents/list</li>
  <li>/incidents/register</li>
  <li>/incidents/incident/key={id}</li>
  <li>/incidents/update/incident/key={id}</li>
  <li>/incidents/delete/incident/key={id}</li>
</ul>

#### Rotas para Biological Weapons
<ul>
  <li>/biologicalWeapons/list</li>
  <li>/biologicalWeapons/register</li>
  <li>/biologicalWeapons/bioWeapon/key={id}</li>
  <li>/biologicalWeapons/update/bioWeapon/key={id}</li>
  <li>/biologicalWeapons/delete/bioWeapon/key={id}</li>
</ul>

#### Rotas para Biological Weapons Types
<ul>
  <li>/bioWeaponTypes/list</li>
  <li>/bioWeaponTypes/register</li>
  <li>/bioWeaponTypes/bioWeaponType/key={id}</li>
  <li>/bioWeaponTypes/update/bioWeaponType/key={id}</li>
  <li>/bioWeaponTypes/delete/bioWeaponType/key={id}</li>
</ul>
