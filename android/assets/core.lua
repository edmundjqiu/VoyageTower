gameAPI = require('scripting/GameAPI')

-- The issue with the Lua-Java binding is that the methods that Lua
-- can call must be static. We can't use non-static information from a
-- static context, so therefore we must provide the non-static Stage 
-- instance from here
function registerStage(stage)
	stageReference = stage
end

function constructEnemy(xCoord, yCoord, controlFunctionName)
	gameAPI.newEnemy(xCoord, yCoord, controlFunctionName, stageReference)
end

function spawnEnemy(x, y, enemyType)
	if enemyType == "BASIC" then
		print("CONSTRUCT");
		constructEnemy(x, y, "basicEnemyAct");
	end
end
