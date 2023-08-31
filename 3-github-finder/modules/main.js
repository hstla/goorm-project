/**
 * github finder api
 * https://api.github.com/users/user
 * https://api.github.com/users/user/repos
 */
import { Github } from './github.js';
import { UI } from './ui.js';

const github = new Github;
const ui = new UI;

const searchUser = document.getElementById('searchUser');

function handleSearch() {
  const userText = searchUser.value;
  if (userText !== '') {
    github.getUser(userText)
      .then(data => {
        console.log(data);
        if (data.profile.message === 'Not Found') {
          ui.showAlert('유저를 찾지 못했어요!', 'alert-danger');
        } else {
          ui.showProfile(data.profile);
          ui.showRepos(data.repos);
        }
      });
  } else {
    ui.clearProfile();
  }
}


searchUser.addEventListener('keyup', (e) => {
  if (e.key === "Enter") {
    handleSearch();
  }
});

searchUser.addEventListener('blur', handleSearch);
