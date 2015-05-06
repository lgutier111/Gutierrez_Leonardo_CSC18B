SELECT entity_user.first_name, entity_user.last_name, entity_history.game_score, entity_history.game_level, enum_status.status_name 

FROM xref_user_history, entity_history, entity_user, enum_status 

WHERE xref_user_history.game_id = entity_history.game_id 

AND xref_user_history.user_id = entity_user.user_id 

AND enum_status.enum_status_id = entity_user.status