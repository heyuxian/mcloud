// use localStorage to store the authority info, which might be sent from server in actual project.
export function getAuthority() {
  const roles = localStorage.getItem('roles') || '';
  return roles.split(',');
}

export function setAuthority(authority) {
  if (authority) {
    localStorage.setItem('roles', authority.roles);
    localStorage.setItem('accessToken', authority.access_token);
    localStorage.setItem('expiresIn', authority.expires_in);
    localStorage.setItem('refreshToken', authority.refresh_token);
    localStorage.setItem('refreshExpires_in', authority.refresh_token);
    localStorage.setItem('tokenType', authority.refresh_token);
    localStorage.setItem('sessionState', authority.session_state);
  } else {
    localStorage.removeItem('roles');
    localStorage.removeItem('accessToken');
    localStorage.removeItem('expiresIn');
    localStorage.removeItem('refreshToken');
    localStorage.removeItem('refreshExpires_in');
    localStorage.removeItem('tokenType');
    localStorage.removeItem('sessionState');
  }
}

export function getAccessToken() {
  const accessToken = localStorage.getItem('accessToken');
  if (!accessToken) {
    return null;
  }
  return `Bearer ${accessToken}`;
}
