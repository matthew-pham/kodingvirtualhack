<?php
$server_seed = "39b7d32fcb743c244c569a56d6de4dc27577d6277d6cf155bdcba6d05befcb34";
$lotto = "0422262831";
$round_id = "1";
$hash = hash("sha256",$server_seed."-".$lotto."-".$round_id);
$roll = hexdec(substr($hash,0,8)) % 15;
echo "Round $round_id = $roll";