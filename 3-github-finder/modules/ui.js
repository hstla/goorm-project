export class UI {
  constructor() {
    this.profile = document.getElementById('profile');
  }

  showProfile(user) {
    // console.log(user);

    this.profile.innerHTML = `
      <div class="profile-box">
  <div class="row">
    <div class="profile-picture">
      <img src="${user.avatar_url}">
        <a href="${user.html_url}" target="_blank">View Profile</a>
    </div>
    <div class="profile-detail">
      <span class="badge blue">Public Repositories: ${user.public_repos}</span>
      <span class="badge gray">Public Gists: ${user.public_gists}</span>
      <span class="badge green">Followers: ${user.followers}</span>
      <span class="badge cyan">Following: ${user.following}</span>
      <br><br>
        <ul class="list-group">
          <li class="list-group-item"><strong>Company:</strong> ${user.company}</li>
          <li class="list-group-item"><strong>Website/Blog:</strong> <a href="${user.blog}"target="_blank">${user.blog}</a></li>
          <li class="list-group-item"><strong>Location:</strong> ${user.location}</li>
          <li class="list-group-item"><strong>Member Since:</strong> ${new Date(user.created_at).toDateString()}
          </li>
        </ul>
      </div>
    </div>
  </div>
    <div class="container grass">
      <img src="https://ghchart.rshah.org/${user.login}"/>
    </div>

  <h3 class="repos-h3">Latest Repositories</h3>
      <div id="repos">
      </div>
    `;
  }

  showRepos(repos) {
    let output = '';

    repos.forEach((repo) => {
      output += `
         <div id="repos">
      <div class="repos-box">
        <div class="row">
          <div class="repos-detail">
            <a href="${repo.html_url}" target="_blank">${repo.name}</a>
          </div>
          <div class="repos-detail">
            <span class="badge blue">Stars: ${repo.stargazers_count}</span>
            <span class="badge gray">Watchers: ${repo.watchers_count}</span>
            <span class="badge green">Forks: ${repo.forks_count}</span>
            <span class="badge cyan">Language: ${repo.language}</span>

          </div>
        </div>
      </div>
    </div>
      `
    });

    document.getElementById('repos').innerHTML = output;
  }

  // 찾지 못햌어요, alet-danger
  showAlert(message, className) {
    this.clearAlert();

    const div = document.createElement('div');
    console.log(div);
    div.className = className;

    div.appendChild(document.createTextNode(message));

    const container = document.querySelector('.search-card');

    // console.log(search);

    container.appendChild(div);

    setTimeout(() => {
      this.clearAlert();
    }, 5000);
  }

  clearAlert() {
    const currentAlert = document.querySelector('.alert-danger');

    if (currentAlert) {
      currentAlert.remove();
    }
  }

  clearProfile() {
    this.profile.innerHTML = '';
  }
}
